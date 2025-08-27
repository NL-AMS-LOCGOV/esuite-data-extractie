package net.atos.esuite.extract.db.repository.dsr

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.dsr.tabel.ReferentietabelRecordEntity

@ApplicationScoped
class ReferentietabelRecordRepository : PanacheRepository<ReferentietabelRecordEntity> {

    fun countByReferentietabelDefinitieId(referentietabelDefinitieId: Long): Long {
        return count("referentietabelDefinitie.identifier", referentietabelDefinitieId)
    }

    fun listByReferentietabelNaam(referentietabelNaam: String) =
        find("referentietabelDefinitie.naam = ?1", referentietabelNaam)
}

