package net.atos.esuite.extract.db.repository.dsr

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.dsr.tabel.ReferentietabelRecordEntity
import net.atos.esuite.extract.db.util.ListResult

@ApplicationScoped
class ReferentietabelRecordRepository : PanacheRepository<ReferentietabelRecordEntity> {

    fun countByReferentietabelDefinitieId(referentietabelDefinitieId: Long): Long {
        return count("referentietabelDefinitie.identifier", referentietabelDefinitieId)
    }

    fun listByReferentietabelNaam(referentietabelNaam: String, pageIndex: Int, pageSize: Int): ListResult<ReferentietabelRecordEntity> {
        val filter = "referentietabelDefinitie.naam = ?1"
        return ListResult(
            find(filter, referentietabelNaam).page(pageIndex, pageSize).list(),
            find(filter, referentietabelNaam).count().toInt()
        )
    }
}

