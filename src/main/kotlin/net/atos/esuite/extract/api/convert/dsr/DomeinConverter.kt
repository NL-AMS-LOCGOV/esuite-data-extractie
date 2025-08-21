package net.atos.esuite.extract.api.convert.dsr

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.api.model.dsr.domein.Domein
import net.atos.esuite.extract.db.entity.dsr.definitie.DomeinDefinitieEntity
import net.atos.esuite.extract.db.repository.dsr.DomeinObjectRepository

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
