package net.atos.esuite.extract.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.persistence.EntityManager
import jakarta.persistence.criteria.CriteriaBuilder
import net.atos.esuite.extract.entity.identity.AfdelingEntity

abstract class BaseRepository<ENTITY : Any>(private val entityClass: Class<ENTITY>) : PanacheRepository<ENTITY> {

    fun findByNaam(naam: String) =
        find("naam", naam).firstResult()

    fun listAll(
        pageIndex: Int,
        pageSize: Int
    ): ListResult<ENTITY> {
        val em = getEntityManager()
        val cb = em.criteriaBuilder
        return ListResult(
            listAll(em, cb, pageIndex, pageSize),
            countAll(em, cb)
        )
    }

    private fun listAll(
        em: EntityManager,
        cb: CriteriaBuilder,
        pageIndex: Int,
        pageSize: Int,
    ): List<ENTITY> {
        val query = cb.createQuery(entityClass)
        val root = query.from(entityClass)
        query.select(root)
        return with(em.createQuery(query)) {
            firstResult = pageIndex * pageSize
            maxResults = pageSize
            resultList
        }
    }

    private fun countAll(
        em: EntityManager,
        cb: CriteriaBuilder,
    ): Int {
        val query = cb.createQuery(Long::class.javaObjectType)
        val root = query.from(entityClass)
        query.select(cb.count(root))
        return em.createQuery(query).singleResult.toInt()
    }
}
