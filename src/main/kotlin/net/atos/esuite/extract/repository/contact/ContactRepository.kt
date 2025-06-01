package net.atos.esuite.extract.repository.contact

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
import jakarta.persistence.criteria.CriteriaBuilder
import net.atos.esuite.extract.entity.contactenmagazijn.ContactEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class ContactRepository : PanacheRepository<ContactEntity> {

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()

    fun list(
        pageIndex: Int,
        pageSize: Int
    ): ListResult<ContactEntity> {
        val em = getEntityManager()
        val cb = em.criteriaBuilder
        return ListResult(
            list(em, cb, pageIndex, pageSize),
            count(em, cb)
        )
    }

    private fun list(
        em: EntityManager,
        cb: CriteriaBuilder,
        pageIndex: Int,
        pageSize: Int
    ): List<ContactEntity> {
        val contactQuery = cb.createQuery(ContactEntity::class.java)
        val contactRoot = contactQuery.from(ContactEntity::class.java)
        contactQuery.select(contactRoot)
        return with(em.createQuery(contactQuery)) {
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
        val contactRoot = countQuery.from(ContactEntity::class.java)
        countQuery.select(cb.count(contactRoot))
        return em.createQuery(countQuery).singleResult.toInt()
    }
}
