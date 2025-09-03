package net.atos.esuite.extract.api.convert.zaak

import net.atos.esuite.extract.api.model.zaaktype.Zaaktype
import net.atos.esuite.extract.api.model.zaaktype.ZaaktypeOverzicht
import net.atos.esuite.extract.db.entity.zakenmagazijn.ZaakTypeEntity


fun ZaakTypeEntity.toZaaktypeOverzicht() = ZaaktypeOverzicht(
    naam = naam,
    functioneleIdentificatie = functioneelId,
    omschrijving = omschrijving,
    actief = actief,
)

fun ZaakTypeEntity.toZaaktype() = Zaaktype()
