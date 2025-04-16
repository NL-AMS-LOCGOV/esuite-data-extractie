package net.atos.esuite.extract.converter

import net.atos.esuite.extract.entity.zakenmagazijn.*
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractDataElementEntity
import net.atos.esuite.extract.model.*

fun ReferentieZaakTypeEntity.toZaaktype() =
    Zaaktype(
        naam = naam,
        functioneleIdentificatie = functioneelId,
        omschrijving = omschrijving,
        actief = actief,
    )

fun ReferentieZaakStatusEntity.toZaakstatus() =
    Zaakstatus(
        naam = naam,
        omschrijving = omschrijving,
        uitwisselingscode = uitwisselingsCode,
        externeNaam = externeNaam,
    )

fun ReferentieResultaatEntity.toResultaat() =
    Resultaat(
        naam = naam,
        omschrijving = omschrijving,
        uitwisselingscode = uitwisselingsCode,
    )

fun BesluitEntity.toBesluit() =
    Besluit(
        besluitDatum = besluitdatum
    )

fun BetaalgegevensEntity.toBetaalgegevens() =
    Betaalgegevens(
        transactieId = transactieId,
        kenmerk = kenmerk,
        bedrag = bedrag,
        transactieDatum = transactieDatum,
        ncerror = ncerror,
        origineleStatusCode = origineleStatusCode,
        betaalstatus =
            when (betaalstatus) {
                BetaalstatusEnum.GESLAAGD -> Betaalstatus.geslaagd
                BetaalstatusEnum.NIET_GESLAAGD -> Betaalstatus.niet_geslaagd
                BetaalstatusEnum.IN_BEHANDELING -> Betaalstatus.in_behandeling
                BetaalstatusEnum.GEANNULEERD -> Betaalstatus.geannuleerd
                null -> null
            }
    )

fun ArchiveergegevensEntity.toArchiveergegevens() =
    ArchiveerGegevens(
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
        isBeperkingOpenbaarheid = beperkingOpenbaarheid,
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

fun OvergebrachteGegevensEntity.toOvergebrachteGegevens() =
    OvergebrachteGegevens(
        overgebrachtOp = overgebrachtOp,
        overgebrachtDoor = overgebrachtDoor,
        overgebrachtNaar = overgebrachtNaar,
    )

fun ZaakHistorieEntity.toZaakHistorie() =
    ZaakHistorie(
        wijzigingDatum = datumwijziging,
        gewijzigdDoor = gewijzigddoor,
        oudeWaarde = oudewaarde,
        nieuweWaarde = nieuwewaarde,
        toelichting = toelichting,
        typeWijziging = ZaakHistorieTypeWijziging.valueOf(typeWijziging.lowercase()),
        nieuweWaardeExtern = nieuweWaardeExtern,
    )

fun ZaakNotitieEntity.toZaakNotitie() =
    ZaakNotitie(
        medewerker = medewerkerId,
        datumTijd = datumTijd.toZonedDateTime(),
        notitie = notitie,
    )

fun AbstractDataElementEntity.toZaakData() =
    ZaakData()

fun DocumentEntity.toDocument() =
    Document()

fun ZaakBAGObjectEntity.toBAGObject() =
    BAGObject()

fun ZaakBetrokkeneEntity.toZaakBetrokkene() =
    ZaakBetrokkene()

fun TaakEntity.toTaak() =
    Taak()

fun ZaakZaakEntity.toGekoppeldeZaak() =
    GekoppeldeZaak()

fun ZaakContactEntity.toContact() =
    Contact()
