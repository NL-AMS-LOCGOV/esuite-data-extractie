package net.atos.esuite.extract.converter.dsr

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.dsr.definitie.ReferentietabelDefinitieEntity
import net.atos.esuite.extract.model.dsr.ReferentietabelOverzicht
import net.atos.esuite.extract.repository.dsr.ReferentietabelRecordRepository

@ApplicationScoped
class ReferentietabelConverter(
    private val referentietabelRecordRepository: ReferentietabelRecordRepository,
) {
    fun toReferentietabelOverzicht(referentietabelDefinitieEntity: ReferentietabelDefinitieEntity) =
        ReferentietabelOverzicht(
            naam = referentietabelDefinitieEntity.naam,
            omschrijving = referentietabelDefinitieEntity.omschrijving,
            aantalRecords = referentietabelRecordRepository.countByReferentietabelDefinitieId(referentietabelDefinitieEntity.identifier)
        )
}
