package net.atos.esuite.extract.converter

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.ZaakEntity
import net.atos.esuite.extract.model.ZaakOverzicht

@ApplicationScoped
class ZaakOverzichtConverter {

    fun convert(zaakEntity: ZaakEntity): ZaakOverzicht {
        return ZaakOverzicht(
            functioneleIdentificatie = zaakEntity.functioneelId,
            zaaktypeNaam = "",
        )
    }
}
