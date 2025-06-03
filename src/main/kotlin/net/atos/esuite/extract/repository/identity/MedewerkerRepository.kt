package net.atos.esuite.extract.repository.identity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.criteria.CriteriaBuilder
import net.atos.esuite.extract.entity.identity.MedewerkerEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class MedewerkerRepository : PanacheRepository<MedewerkerEntity> {

    fun list(
        pageIndex: Int,
        pageSize: Int
    ): ListResult<MedewerkerEntity> {
        val em = getEntityManager()
        val cb = em.criteriaBuilder
        return ListResult(
            list(em, cb, pageIndex, pageSize),
            count(em, cb)
        )
    }

    fun findByGebruikersnaam(gebruikersnaam: String) : MedewerkerEntity? =
        find("gebruikersnaam", gebruikersnaam).firstResult()

    private fun list(
        em: EntityManager,
        cb: CriteriaBuilder,
        pageIndex: Int,
        pageSize: Int,
    ): List<MedewerkerEntity> {
        val query = cb.createQuery(MedewerkerEntity::class.java)
        val root = query.from(MedewerkerEntity::class.java)
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
        val root = query.from(MedewerkerEntity::class.java)
        query.select(cb.count(root))
        return em.createQuery(query).singleResult.toInt()
    }
}
