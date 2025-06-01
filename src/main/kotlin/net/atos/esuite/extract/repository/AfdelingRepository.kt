package net.atos.esuite.extract.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
import jakarta.persistence.criteria.CriteriaBuilder
import net.atos.esuite.extract.entity.identity.AfdelingEntity

@ApplicationScoped
class AfdelingRepository : PanacheRepository<AfdelingEntity> {

    fun list(
        pageIndex: Int,
        pageSize: Int
    ): ListResult<AfdelingEntity> {
        val em = getEntityManager()
        val cb = em.criteriaBuilder
        return ListResult(
            list(em, cb, pageIndex, pageSize),
            count(em, cb)
        )
    }

    fun findByNaam(naam: String) : AfdelingEntity? =
        find("naam", naam).firstResult()

    private fun list(
        em: EntityManager,
        cb: CriteriaBuilder,
        pageIndex: Int,
        pageSize: Int,
    ): List<AfdelingEntity> {
        val query = cb.createQuery(AfdelingEntity::class.java)
        val root = query.from(AfdelingEntity::class.java)
        query.select(root)
        return with(em.createQuery(query)) {
            firstResult = pageIndex * pageSize
            maxResults = pageSize
            resultList
        }
    }

    private fun count(
        em: EntityManager,
        cb: CriteriaBuilder,
    ): Int {
        val query = cb.createQuery(Long::class.javaObjectType)
        val root = query.from(AfdelingEntity::class.java)
        query.select(cb.count(root))
        return em.createQuery(query).singleResult.toInt()
    }
}
