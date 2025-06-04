package net.atos.esuite.extract.converter.dsr

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.dsr.definitie.DomeinDefinitieEntity
import net.atos.esuite.extract.model.dsr.domein.Domein
import net.atos.esuite.extract.model.dsr.domein.DomeinObject
import net.atos.esuite.extract.model.dsr.tabel.Referentietabel
import net.atos.esuite.extract.repository.dsr.DomeinObjectRepository
import net.atos.esuite.extract.repository.dsr.ReferentietabelRecordRepository

@ApplicationScoped
class DomeinConverter(
    private val domeinObjectRepository: DomeinObjectRepository,
) {
    fun toDomein(domeinDefinitieEntity: DomeinDefinitieEntity) =
        Domein(
            naam = domeinDefinitieEntity.naam,
            omschrijving = domeinDefinitieEntity.omschrijving,
            actief = domeinDefinitieEntity.actief,
            aantalObjecten = domeinObjectRepository.countByDomeinDefinitieId(domeinDefinitieEntity.identifier),
        )
}
