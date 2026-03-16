package net.atos.esuite.extract.db.dsr.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.dsr.entity.tabel.ReferentietabelRecordEntity

@Singleton
class ReferentietabelRecordRepository : PanacheRepository<ReferentietabelRecordEntity> {

    fun countByReferentietabelDefinitieId(referentietabelDefinitieId: Long): Long {
        return count("referentietabelDefinitie.identifier", referentietabelDefinitieId)
    }

    fun listByReferentietabelNaam(referentietabelNaam: String) =
        find("referentietabelDefinitie.naam = ?1", referentietabelNaam)
}

