package net.atos.esuite.extract.converter

import net.atos.esuite.extract.entity.zakenmagazijn.*
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractDataElementEntity
import net.atos.esuite.extract.model.*

fun ReferentieZaakTypeEntity.toZaaktype() = Zaaktype(
    naam = naam,
    functioneleIdentificatie = functioneelId,
    omschrijving = omschrijving,
    actief = actief,
)

fun ReferentieZaakStatusEntity.toZaakstatus() = Zaakstatus(
    naam = naam,
    omschrijving = omschrijving,
    uitwisselingscode = uitwisselingsCode,
    externeNaam = externeNaam,
)

fun ReferentieResultaatEntity.toResultaat() = Resultaat(
    naam = naam,
    omschrijving = omschrijving,
    uitwisselingscode = uitwisselingsCode,
)

fun ReferentieBesluitcategorieEntity.toBesluitcategory() = Besluitcategorie(
    naam = naam,
    omschrijving = omschrijving,
)

fun ReferentieBesluittypeEntity.toBesluittype() = Besluittype(
    naam = naam,
    omschrijving = omschrijving,
    besluitcategorie = besluitcategorie.toBesluitcategory(),
    reactietermijnInDagen = reactietermijnInDagen,
    publicatieIndicatie = publicatieIndicatie,
    publicatietekst = publicatietekst,
    publicatietermijnInDagen = publicatietermijnInDagen,
)

fun BetaalgegevensEntity.toBetaalgegevens() = Betaalgegevens(
    transactieId = transactieId,
    kenmerk = kenmerk,
    bedrag = bedrag,
    transactieDatum = transactieDatum,
    ncerror = ncerror,
    origineleStatusCode = origineleStatusCode,
    betaalstatus = when (betaalstatus) {
        BetaalstatusEnum.GESLAAGD -> Betaalstatus.geslaagd
        BetaalstatusEnum.NIET_GESLAAGD -> Betaalstatus.niet_geslaagd
        BetaalstatusEnum.IN_BEHANDELING -> Betaalstatus.in_behandeling
        BetaalstatusEnum.GEANNULEERD -> Betaalstatus.geannuleerd
        null -> null
    }
)

fun ArchiveergegevensEntity.toArchiveergegevens() = ArchiveerGegevens(
    reviewTermijnEinddatum = reviewtermijnEinde,
    bewaartermijnEinddatum = bewaartermijnEinde,
    bewaartermijnWaardering = when (bewaartermijnWaardering) {
        "B" -> BewaartermijnWaardering.bewaar
        "V" -> BewaartermijnWaardering.vernietig
        else -> null
    },
    overbrengenOp = overbrengenOp,
    overbrengenNaar = overbrengenNaar,
    overbrengenDoor = overbrengenDoor,
    beperkingOpenbaarheid = beperkingOpenbaarheid,
    beperkingOpenbaarheidReden = beperkingOpenbaarheidReden,
    beperkingOpenbaarheidVanaf = beperkingOpenbaarheidVanaf,
    beperkingOpenbaarheidTotEnMet = beperkingOpenbaarheidTotEnMet,
    selectielijstItemNaam = selectielijstItemNaam,
    overbrengenType = when (overbrengenType) {
        "1" -> OverbrengenType.overdragen
        "2" -> OverbrengenType.overbrengen
        else -> null
    },
    overgebrachteGegevens = overgebrachteGegevensEntity?.toOvergebrachteGegevens(),
)

fun OvergebrachteGegevensEntity.toOvergebrachteGegevens() = OvergebrachteGegevens(
    overgebrachtOp = overgebrachtOp,
    overgebrachtDoor = overgebrachtDoor,
    overgebrachtNaar = overgebrachtNaar,
)

fun ZaakHistorieEntity.toZaakHistorie() = ZaakHistorie(
    wijzigingDatum = datumwijziging,
    gewijzigdDoor = gewijzigddoor,
    oudeWaarde = oudewaarde,
    nieuweWaarde = nieuwewaarde,
    toelichting = toelichting,
    typeWijziging = ZaakHistorieTypeWijziging.valueOf(typeWijziging.lowercase()),
    nieuweWaardeExtern = nieuweWaardeExtern,
)

fun ZaakNotitieEntity.toZaakNotitie() = ZaakNotitie(
    medewerker = medewerkerId,
    datumTijd = datumTijd.toZonedDateTime(),
    notitie = notitie,
)

fun AbstractDataElementEntity.toZaakData() = ZaakData()

fun ZaakBAGObjectEntity.toBAGObject() = BAGObject(
    bagObjectId = bagObjectId,
)

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
)

fun ZaakZaakEntity.toZaakZaakKoppeling() = ZaakZaakKoppeling(
    dossierEigenaar = dossierEigenaar, gekoppeldeZaak = zaak.functioneelId, relatietype = when (relatietypeId) {
        "HZ" -> ZaakRelatietype.hoofdzaak
        "DZ" -> ZaakRelatietype.deelzaak
        "GZ" -> ZaakRelatietype.gerelateerde_zaak
        "VAZ" -> ZaakRelatietype.voorafgaande_zaak
        "VVZ" -> ZaakRelatietype.vervolgzaak
        else -> error("Invalid relatietypeId: $relatietypeId")
    }
)

fun TaakHistorieEntity.toTaakHistorie() = TaakHistorie(
    wijzigingDatum = datumwijziging,
    gewijzigdDoor = gewijzigddoor,
    oudeWaarde = oudewaarde,
    nieuweWaarde = nieuwewaarde,
    toelichting = toelichting,
    typeWijziging = TaakHistorieTypeWijziging.valueOf(typeWijziging.lowercase()),
)
