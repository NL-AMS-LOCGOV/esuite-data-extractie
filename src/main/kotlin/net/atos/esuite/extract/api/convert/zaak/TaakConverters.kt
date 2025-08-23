package net.atos.esuite.extract.api.convert.zaak

import net.atos.esuite.extract.api.convert.shared.toZonedDateTime
import net.atos.esuite.extract.api.model.zaak.Taak
import net.atos.esuite.extract.api.model.zaak.TaakHistorie
import net.atos.esuite.extract.api.model.zaak.TaakHistorieTypeWijziging
import net.atos.esuite.extract.api.model.zaak.Taaktype
import net.atos.esuite.extract.db.entity.zakenmagazijn.TaakEntity
import net.atos.esuite.extract.db.entity.zakenmagazijn.TaakHistorieEntity

fun TaakEntity.toTaak() = Taak(
    afdeling = afdelingId,
    functioneelIdentificatie = functioneelId,
    groep = groepId,
    behandelaar = behandelaarId,
    startdatum = startdatum,
    streefdatum = streefdatum,
    fataledatum = fataledatum,
    einddatum = einddatum?.toZonedDateTime(),
    procesTaak = procesTaakId,
    indicatieExternToegankelijk = indicatieExternToegankelijk,
    afgehandeldDoor = afgehandeldDoor,
    taaktype = Taaktype.valueOf(taakType.lowercase()),
    taaktypeOrigineel = Taaktype.valueOf(taakTypeOrigineel.lowercase()),
    opschorttermijnStartdatum = opschorttermijnStartdatum,
    opschorttermijnEinddatum = opschorttermijnEinddatum,
    historie = historie.map { it.toTaakHistorie() },
    vestigingsnummer = vestigingsnummer,
    kvkNummer = kvkNummer,
    authenticatieniveau = authenticatieniveau,
    processtap = processtap,
    toekenningEmail = toekenningEmail,
)

private fun TaakHistorieEntity.toTaakHistorie() = TaakHistorie(
    wijzigingDatum = datumwijziging,
    gewijzigdDoor = gewijzigddoor,
    oudeWaarde = oudewaarde,
    nieuweWaarde = nieuwewaarde,
    toelichting = toelichting,
    typeWijziging = TaakHistorieTypeWijziging.valueOf(typeWijziging.lowercase()),
)
