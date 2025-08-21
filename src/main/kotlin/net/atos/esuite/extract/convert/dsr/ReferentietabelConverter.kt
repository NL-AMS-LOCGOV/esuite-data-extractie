package net.atos.esuite.extract.convert.dsr

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.api.model.dsr.tabel.Referentietabel
import net.atos.esuite.extract.db.entity.dsr.definitie.ReferentietabelDefinitieEntity
import net.atos.esuite.extract.db.repository.dsr.ReferentietabelRecordRepository

@ApplicationScoped
class ReferentietabelConverter(
    private val referentietabelRecordRepository: ReferentietabelRecordRepository,
) {
    fun toReferentietabel(referentietabelDefinitieEntity: ReferentietabelDefinitieEntity) =
        Referentietabel(
            naam = referentietabelDefinitieEntity.naam,
            omschrijving = referentietabelDefinitieEntity.omschrijving,
            actief = referentietabelDefinitieEntity.actief,
            masterDetail = referentietabelDefinitieEntity.masterDetail,
            aantalRecords = referentietabelRecordRepository.countByReferentietabelDefinitieId(referentietabelDefinitieEntity.identifier)
        )
}
