package net.atos.esuite.extract.api.converter

import net.atos.esuite.extract.api.model.taak.Taak
import net.atos.esuite.extract.api.model.taak.TaakHistorie
import net.atos.esuite.extract.api.model.taak.TaakHistorieTypeWijziging
import net.atos.esuite.extract.api.model.taak.Taaktype
import net.atos.esuite.extract.db.zakenmagazijn.entity.TaakEntity
import net.atos.esuite.extract.db.zakenmagazijn.entity.TaakHistorieEntity

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
    taaktype = taakType.toTaaktype(),
    taaktypeOrigineel = taakTypeOrigineel.toTaaktype(),
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

private fun String.toTaaktype() =
    when (this.lowercase()) {
        "standaard" -> Taaktype.standaard
        "iburgerzaken" -> Taaktype.iburgerzaken
        "extern" -> Taaktype.extern
        "extern ketenpartner" -> Taaktype.extern_ketenpartner
        else -> error("Invalid Taaktype: $this")
    }
