package net.atos.esuite.extract.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.ZaakEntity
import net.atos.esuite.extract.entity.ZaaktypeEntity

@ApplicationScoped
class ZaakRepository(
    private val zaaktypeReposotory: ZaaktypeRepository,
) : PanacheRepository<ZaakEntity> {

    companion object {
        private const val ZAAKTYPE_ID_PREFIX = "ZTC2:"
    }

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()

    fun listByZaaktypeFunctioneelId(zaaktypeFunctioneelId: String, pageIndex: Int, pageSize: Int) =
        zaaktypeReposotory.find("functioneelId", zaaktypeFunctioneelId).firstResult()
            ?.let {
                find("zaaktypeId", "$ZAAKTYPE_ID_PREFIX${it.identifier}")
                    .page(pageIndex, pageSize)
                    .list()
            }
            ?: emptyList()

    fun listByZaaktypeFunctioneelId2(zaaktypeFunctioneelId: String, pageIndex: Int, pageSize: Int): List<ZaakEntity> {
        val em = getEntityManager()
        val cb = em.criteriaBuilder

        val zaakQuery = cb.createQuery(ZaakEntity::class.java)
        val zaakRoot = zaakQuery.from(ZaakEntity::class.java)

        val zaaktypeSubquery = zaakQuery.subquery(String::class.java)
        val zaaktypeRoot = zaaktypeSubquery.from(ZaaktypeEntity::class.java)

        zaaktypeSubquery
            .select(
                cb.concat(
                    cb.literal(ZAAKTYPE_ID_PREFIX), zaaktypeRoot.get<Long>("identifier").`as`(String::class.java)
                )
            ).where(cb.equal(zaaktypeRoot.get<String>("functioneelId"), zaaktypeFunctioneelId))

        zaakQuery
            .select(zaakRoot)
            .where(cb.equal(zaakRoot.get<String>("zaaktypeId"), zaaktypeSubquery))

        return with(em.createQuery(zaakQuery)) {
            firstResult = pageIndex * pageSize
            maxResults = pageSize
            resultList
        }
    }

    fun countByZaaktypeFunctioneelId(zaaktypeFunctioneelId: String): Int {
        val em = getEntityManager()
        val cb = em.criteriaBuilder

        val zaakQuery = cb.createQuery(Long::class.javaObjectType)
        val zaakRoot = zaakQuery.from(ZaakEntity::class.java)

        val zaaktypeSubquery = zaakQuery.subquery(String::class.java)
        val zaaktypeRoot = zaaktypeSubquery.from(ZaaktypeEntity::class.java)

        zaaktypeSubquery
            .select(
                cb.concat(
                    cb.literal(ZAAKTYPE_ID_PREFIX), zaaktypeRoot.get<Long>("identifier").`as`(String::class.java)
                )
            ).where(cb.equal(zaaktypeRoot.get<String>("functioneelId"), zaaktypeFunctioneelId))

        zaakQuery
            .select(cb.count(zaakRoot))
            .where(cb.equal(zaakRoot.get<String>("zaaktypeId"), zaaktypeSubquery))

          return em.createQuery(zaakQuery).singleResult.toInt()
    }
}
