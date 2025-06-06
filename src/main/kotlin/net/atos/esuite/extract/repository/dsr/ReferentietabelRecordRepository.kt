package net.atos.esuite.extract.repository.dsr

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Root
import net.atos.esuite.extract.entity.dsr.definitie.ReferentietabelDefinitieEntity
import net.atos.esuite.extract.entity.dsr.tabel.ReferentietabelRecordEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class ReferentietabelRecordRepository : PanacheRepository<ReferentietabelRecordEntity> {

    fun countByReferentietabelDefinitieId(referentietabelDefinitieId: Long): Long {
        return count("referentietabelDefinitie.identifier", referentietabelDefinitieId)
    }

    fun listByReferentietabelNaam(
        referentietabelNaam: String,
        pageIndex: Int,
        pageSize: Int
    ): ListResult<ReferentietabelRecordEntity> {
        val em = getEntityManager()
        val cb = em.criteriaBuilder
        return ListResult(
            listByReferentietabelNaam(em, cb, referentietabelNaam, pageIndex, pageSize),
            countByReferentietabelNaam(em, cb, referentietabelNaam)
        )
    }

    private fun listByReferentietabelNaam(
        em: EntityManager, cb: CriteriaBuilder, referentietabelNaam: String, pageIndex: Int, pageSize: Int
    ): List<ReferentietabelRecordEntity> {
        val query = cb.createQuery(ReferentietabelRecordEntity::class.java)
        val root = query.from(ReferentietabelRecordEntity::class.java)
        query
            .select(root)
            .where(createPredicate(cb, root, referentietabelNaam))
        return with(em.createQuery(query)) {
            firstResult = pageIndex * pageSize
            maxResults = pageSize
            resultList
        }
    }

    private fun countByReferentietabelNaam(em: EntityManager, cb: CriteriaBuilder, referentietabelNaam: String): Int {
        val query = cb.createQuery(Long::class.javaObjectType)
        val root = query.from(ReferentietabelRecordEntity::class.java)
        query
            .select(cb.count(root))
            .where(createPredicate(cb, root, referentietabelNaam))
        return em.createQuery(query).singleResult.toInt()
    }

    private fun createPredicate(
        cb: CriteriaBuilder,
        root: Root<ReferentietabelRecordEntity>,
        referentietabelNaam: String
    ) =
        cb.equal(
            root.get<ReferentietabelDefinitieEntity>("referentietabelDefinitie").get<String>("naam"),
            referentietabelNaam
        )
}

