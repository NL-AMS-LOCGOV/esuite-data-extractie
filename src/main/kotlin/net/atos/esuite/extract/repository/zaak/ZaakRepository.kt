package net.atos.esuite.extract.repository.zaak

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.zakenmagazijn.ZaakEntity
import jakarta.persistence.EntityManager
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import net.atos.esuite.extract.entity.zakenmagazijn.ReferentieZaakTypeEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class ZaakRepository : PanacheRepository<ZaakEntity> {

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
        val query = cb.createQuery(ZaakEntity::class.java)
        val root = query.from(ZaakEntity::class.java)
        query.select(root)
        createZaaktypeSubQuery(cb, query, root, zaaktypeFunctioneelId)
        return with(em.createQuery(query)) {
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
        val query = cb.createQuery(Long::class.javaObjectType)
        val root = query.from(ZaakEntity::class.java)
        query.select(cb.count(root))
        createZaaktypeSubQuery(cb, query, root, zaaktypeFunctioneelId)
        return em.createQuery(query).singleResult.toInt()
    }

    private fun <T> createZaaktypeSubQuery(
        cb: CriteriaBuilder,
        query: CriteriaQuery<T>,
        root: Root<ZaakEntity>,
        zaaktypeFunctioneelId: String
    ) {
        val subquery = query.subquery(String::class.java)
        val subqueryRoot = subquery.from(ReferentieZaakTypeEntity::class.java)
        subquery
            .select(
                cb.concat(
                    cb.literal(ZAAKTYPE_ID_PREFIX), subqueryRoot.get<Long>("identifier").`as`(String::class.java)
                )
            ).where(cb.equal(subqueryRoot.get<String>("functioneelId"), zaaktypeFunctioneelId))
        query
            .where(cb.equal(root.get<String>("zaaktypeId"), subquery))
    }
}
