package net.atos.esuite.extract.repository.contact

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.criteria.CriteriaBuilder
import net.atos.esuite.extract.entity.contactenmagazijn.ContactEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class ContactRepository : PanacheRepository<ContactEntity> {

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()

    fun listAll(
        pageIndex: Int,
        pageSize: Int
    ): ListResult<ContactEntity> {
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
        pageSize: Int
    ): List<ContactEntity> {
        val query = cb.createQuery(ContactEntity::class.java)
        val root = query.from(ContactEntity::class.java)
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
        val root = query.from(ContactEntity::class.java)
        query.select(cb.count(root))
        return em.createQuery(query).singleResult.toInt()
    }
}
