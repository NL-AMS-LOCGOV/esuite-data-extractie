package net.atos.esuite.extract.repository.identity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
import jakarta.persistence.criteria.CriteriaBuilder
import net.atos.esuite.extract.entity.identity.GroepEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class GroepRepository : PanacheRepository<GroepEntity> {

    fun list(
        pageIndex: Int,
        pageSize: Int
    ): ListResult<GroepEntity> {
        val em = getEntityManager()
        val cb = em.criteriaBuilder
        return ListResult(
            list(em, cb, pageIndex, pageSize),
            count(em, cb)
        )
    }

    fun findByNaam(naam: String) : GroepEntity? =
        find("naam", naam).firstResult()

    private fun list(
        em: EntityManager,
        
        cb: CriteriaBuilder,
        pageIndex: Int,
        pageSize: Int,
    ): List<GroepEntity> {
        val query = cb.createQuery(GroepEntity::class.java)
        val root = query.from(GroepEntity::class.java)
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
        val medewerkerRoot = query.from(GroepEntity::class.java)
        query.select(cb.count(medewerkerRoot))
        return em.createQuery(query).singleResult.toInt()
    }
}
