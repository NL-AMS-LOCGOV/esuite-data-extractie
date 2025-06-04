package net.atos.esuite.extract.converter.dsr

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.dsr.definitie.DomeinDefinitieEntity
import net.atos.esuite.extract.model.dsr.domein.Domein
import net.atos.esuite.extract.model.dsr.domein.DomeinObject
import net.atos.esuite.extract.model.dsr.tabel.Referentietabel
import net.atos.esuite.extract.repository.dsr.ReferentietabelRecordRepository

@ApplicationScoped
class DomeinConverter(
    private val referentietabelRecordRepository: ReferentietabelRecordRepository,
) {
    fun toDomein(domeinDefinitieEntity: DomeinDefinitieEntity) =
        Domein(
            naam = domeinDefinitieEntity.naam,
            omschrijving = domeinDefinitieEntity.omschrijving,
            actief = domeinDefinitieEntity.actief,
            aantalObjecten = 0 // ToDo: implement this
            // aantalRecords = referentietabelRecordRepository.countByReferentietabelDefinitieId(domeinDefinitieEntity.identifier)
        )
}
