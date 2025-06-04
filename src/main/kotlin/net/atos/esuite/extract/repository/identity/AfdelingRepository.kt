package net.atos.esuite.extract.repository.identity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.criteria.CriteriaBuilder
import net.atos.esuite.extract.entity.identity.AfdelingEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class AfdelingRepository : PanacheRepository<AfdelingEntity> {

    fun listAll(
        pageIndex: Int,
        pageSize: Int
    ): ListResult<AfdelingEntity> {
        val em = getEntityManager()
        val cb = em.criteriaBuilder
        return ListResult(
            listAll(em, cb, pageIndex, pageSize),
            countAll(em, cb)
        )
    }

    fun findByNaam(naam: String) : AfdelingEntity? =
        find("naam", naam).firstResult()

    private fun listAll(
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

    private fun countAll(
        em: EntityManager,
        cb: CriteriaBuilder,
    ): Int {
        val query = cb.createQuery(Long::class.javaObjectType)
        val root = query.from(AfdelingEntity::class.java)
        query.select(cb.count(root))
        return em.createQuery(query).singleResult.toInt()
    }
}
