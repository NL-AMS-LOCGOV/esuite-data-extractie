package net.atos.esuite.extract.repository.identity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
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
        val medewerkerQuery = cb.createQuery(MedewerkerEntity::class.java)
        val medewerkerRoot = medewerkerQuery.from(MedewerkerEntity::class.java)
        medewerkerQuery.select(medewerkerRoot)
        return with(em.createQuery(medewerkerQuery)) {
            firstResult = pageIndex * pageSize
            maxResults = pageSize
            resultList
        }
    }

    private fun count(
        em: EntityManager,
        cb: CriteriaBuilder,
    ): Int {
        val countQuery = cb.createQuery(Long::class.javaObjectType)
        val medewerkerRoot = countQuery.from(MedewerkerEntity::class.java)
        countQuery.select(cb.count(medewerkerRoot))
        return em.createQuery(countQuery).singleResult.toInt()
    }
}
