package net.atos.esuite.extract.repository.dsr

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Root
import net.atos.esuite.extract.entity.dsr.definitie.DomeinDefinitieEntity
import net.atos.esuite.extract.entity.dsr.definitie.DomeinObjectDefinitieEntity
import net.atos.esuite.extract.entity.dsr.domein.DomeinObjectEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class DomeinObjectRepository : PanacheRepository<DomeinObjectEntity> {

    fun countByDomeinDefinitieId(domeinDefinitieId: Long): Long {
        return count("domeinObjectDefinitie.domeinDefinitie.identifier", domeinDefinitieId)
    }

    fun listByDomeinNaam(
        domeinNaam: String,
        pageIndex: Int,
        pageSize: Int
    ): ListResult<DomeinObjectEntity> {
        val em = getEntityManager()
        val cb = em.criteriaBuilder
        return ListResult(
            listByDomeinNaam(em, cb, domeinNaam, pageIndex, pageSize),
            countByDomeinNaam(em, cb, domeinNaam)
        )
    }

    private fun listByDomeinNaam(
        em: EntityManager, cb: CriteriaBuilder, domeinNaam: String, pageIndex: Int, pageSize: Int
    ): List<DomeinObjectEntity> {
        val query = cb.createQuery(DomeinObjectEntity::class.java)
        val root = query.from(DomeinObjectEntity::class.java)
        query
            .select(root)
            .where(createPredicate(cb, root, domeinNaam))
        return with(em.createQuery(query)) {
            firstResult = pageIndex * pageSize
            maxResults = pageSize
            resultList
        }
    }

    private fun countByDomeinNaam(em: EntityManager, cb: CriteriaBuilder, domeinNaam: String): Int {
        val query = cb.createQuery(Long::class.javaObjectType)
        val root = query.from(DomeinObjectEntity::class.java)
        query
            .select(cb.count(root))
            .where(createPredicate(cb, root, domeinNaam))
        return em.createQuery(query).singleResult.toInt()
    }

    private fun createPredicate(
        cb: CriteriaBuilder,
        root: Root<DomeinObjectEntity>,
        domeinNaam: String
    ) =
        cb.equal(
            root.get<DomeinObjectDefinitieEntity>("domeinObjectDefinitie")
                .get<DomeinDefinitieEntity>("domeinDefinitie")
                .get<String>("naam"),
            domeinNaam
        )

}

