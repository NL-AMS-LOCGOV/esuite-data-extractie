package net.atos.esuite.extract.api.convert.zaak

import net.atos.esuite.extract.api.model.zaaktype.Zaaktype
import net.atos.esuite.extract.api.model.zaaktype.ZaaktypeOverzicht
import net.atos.esuite.extract.db.entity.zakenmagazijn.ReferentieZaakTypeEntity


fun ReferentieZaakTypeEntity.toZaaktypeOverzicht() = ZaaktypeOverzicht(
    naam = naam,
    functioneleIdentificatie = functioneelId,
    omschrijving = omschrijving,
    actief = actief,
)

fun ReferentieZaakTypeEntity.toZaaktype() = Zaaktype()
