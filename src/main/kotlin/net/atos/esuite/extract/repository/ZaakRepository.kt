package net.atos.esuite.extract.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.zakenmagazijn.ZaakEntity
import jakarta.persistence.EntityManager
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import net.atos.esuite.extract.entity.zakenmagazijn.ReferentieZaakTypeEntity

@ApplicationScoped
class ZaakRepository : PanacheRepository<ZaakEntity> {

    companion object {
        const val ZAAKTYPE_ID_PREFIX = "ZTC2:"
    }

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()

    fun listByZaaktypeFunctioneelId(
        zaaktypeFunctioneelId: String,
        inclusiefOpen: Boolean, // ToDo: Tevens open zaken ophalen
        pageIndex: Int,
        pageSize: Int
    ): ListResult<ZaakEntity> {
        val em = getEntityManager()
        val cb = em.criteriaBuilder
        return ListResult(
            listByZaaktypeFunctioneelId(em, cb, zaaktypeFunctioneelId, pageIndex, pageSize),
            countByZaaktypeFunctioneelId(em, cb, zaaktypeFunctioneelId)
        )
    }

    private fun listByZaaktypeFunctioneelId(
        em: EntityManager,
        cb: CriteriaBuilder,
        zaaktypeFunctioneelId: String,
        pageIndex: Int,
        pageSize: Int
    ): List<ZaakEntity> {
        val zaakQuery = cb.createQuery(ZaakEntity::class.java)
        val zaakRoot = zaakQuery.from(ZaakEntity::class.java)
        zaakQuery.select(zaakRoot)
        createZaaktypeSubQuery(cb, zaakQuery, zaakRoot, zaaktypeFunctioneelId)
        return with(em.createQuery(zaakQuery)) {
            firstResult = pageIndex * pageSize
            maxResults = pageSize
            resultList
        }
    }

    private fun countByZaaktypeFunctioneelId(
        em: EntityManager,
        cb: CriteriaBuilder,
        zaaktypeFunctioneelId: String
    ): Int {
        val countQuery = cb.createQuery(Long::class.javaObjectType)
        val zaakRoot = countQuery.from(ZaakEntity::class.java)
        countQuery.select(cb.count(zaakRoot))
        createZaaktypeSubQuery(cb, countQuery, zaakRoot, zaaktypeFunctioneelId)
        return em.createQuery(countQuery).singleResult.toInt()
    }

    private fun <T> createZaaktypeSubQuery(
        cb: CriteriaBuilder,
        query: CriteriaQuery<T>,
        root: Root<ZaakEntity>,
        zaaktypeFunctioneelId: String
    ) {
        val zaaktypeSubquery = query.subquery(String::class.java)
        val zaaktypeRoot = zaaktypeSubquery.from(ReferentieZaakTypeEntity::class.java)
        zaaktypeSubquery
            .select(
                cb.concat(
                    cb.literal(ZAAKTYPE_ID_PREFIX), zaaktypeRoot.get<Long>("identifier").`as`(String::class.java)
                )
            ).where(cb.equal(zaaktypeRoot.get<String>("functioneelId"), zaaktypeFunctioneelId))
        query
            .where(cb.equal(root.get<String>("zaaktypeId"), zaaktypeSubquery))
    }
}
