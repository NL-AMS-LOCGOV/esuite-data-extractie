package net.atos.esuite.extract.api.converter

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.api.model.bag.BAGObject
import net.atos.esuite.extract.api.model.besluit.Besluit
import net.atos.esuite.extract.api.model.besluit.Besluitcategorie
import net.atos.esuite.extract.api.model.besluit.Besluittype
import net.atos.esuite.extract.api.model.zaak.*
import net.atos.esuite.extract.db.basisgegevens.repository.SubjectRepository
import net.atos.esuite.extract.db.zakenmagazijn.entity.*
import net.atos.esuite.extract.db.zakenmagazijn.repository.*

@ApplicationScoped
class ZaakConverter(
    private val zaakStatusRepository: ZaakStatusRepository,
    private val resultaatRepository: ResultaatRepository,
    private val zaaktypeRepository: ZaaktypeRepository,
    private val documentConverter: DocumentConverter,
    private val besluittypeRepository: BesluittypeRepository,
    private val subjectRepository: SubjectRepository,
) {
    fun toZaak(zaakEntity: ZaakEntity) =
        Zaak(
            aangemaaktDoor = zaakEntity.aangemaaktDoorId,
            afdeling = zaakEntity.afdelingId,
            archiveerGegevens = zaakEntity.archiveergegevens?.toArchiveergegevens(),
            bagObjecten = zaakEntity.gekoppeldeBAGObjecten.map { it.toBAGObject() }.ifEmpty { null },
            behandelaar = zaakEntity.behandelaarId,
            besluiten = zaakEntity.besluiten.map { toBesluit(it) }.ifEmpty { null },
            betaalgegevens = zaakEntity.betaalgegevens?.toBetaalgegevens(),
            betrokkenen = zaakEntity.betrokkenen.map { toZaakBetrokkene(it) }.ifEmpty { null },
            contacten = zaakEntity.contacten.map { it.contact.functioneelId }.ifEmpty { null },
            creatieDatumTijd = zaakEntity.creatiedatum.toZonedDateTime(),
            documenten = zaakEntity.documenten.map { documentConverter.toDocument(it) }.ifEmpty { null },
            einddatum = zaakEntity.einddatum,
            externeIdentificatie = zaakEntity.externFunctioneelId,
            fataledatum = zaakEntity.fataledatum,
            functioneleIdentificatie = zaakEntity.functioneelId,
            geautoriseerdeMedewerkers = zaakEntity.geautoriseerdeMedewerkers.ifEmpty { null },
            gekoppeldeZaken = zaakEntity.relatieZaken.map { it.toZaakZaakKoppeling() }.ifEmpty { null },
            geolocatie = zaakEntity.geolocatie?.convertToGeoJsonGeometry(),
            groep = zaakEntity.groepId,
            historie = zaakEntity.historie.map { it.toZaakHistorie() },
            geautoriseerdVoorMedewerkers = zaakEntity.autorisatie,
            heropend = zaakEntity.indicatieHeropend,
            intake = zaakEntity.indicatieIntake,
            procesGestart = zaakEntity.procesGestart,
            ztc1MigratiedatumTijd = zaakEntity.ztc1Migratiedatumtijd?.toZonedDateTime(),
            vernietiging = zaakEntity.inVernietiging,
            vertrouwelijk = zaakEntity.indicatieVertrouwelijk,
            kanaal = zaakEntity.kanaal.toKanaal(),
            notities = zaakEntity.notities.map { it.toZaakNotitie() }.ifEmpty { null },
            omschrijving = zaakEntity.omschrijving,
            opschorttermijnEinddatum = zaakEntity.opschorttermijnEinddatum,
            opschorttermijnStartdatum = zaakEntity.opschorttermijnStartdatum,
            organisatie = zaakEntity.organisatie?.naam,
            redenStart = zaakEntity.redenStartZaak,
            resultaat = zaakEntity.resultaatId?.let { toResultaat(it) },
            startdatum = zaakEntity.startdatum,
            zaakStatus = toZaakstatus(zaakEntity.statusId),
            streefdatum = zaakEntity.streefdatum,
            taken = zaakEntity.taken.map { it.toTaak() }.ifEmpty { null },
            wijzigDatumTijd = zaakEntity.wijzigdatum?.toZonedDateTime(),
            zaakdata = zaakEntity.zaakdataElementen.map { it.toDataElement() }.ifEmpty { null },
            zaaktype = toZaaktypeOverzicht(zaakEntity.zaaktypeId),
            initiator = zaakEntity.initiatorId?.let {
                subjectRepository.findById(it)
                    ?.toSubject()
                    ?: error("Initiator with id ${it} not found")
            },
            notificeerbaar = zaakEntity.notificeerbaar,
            open = zaakEntity.einddatum == null,
        )

    fun toZaakOverzicht(zaakEntity: ZaakEntity) =
        ZaakOverzicht(
            functioneleIdentificatie = zaakEntity.functioneelId,
            zaakEntity.einddatum == null,
        )

    private fun toZaaktypeOverzicht(zaaktypeId: String) =
        zaaktypeRepository.findById(zaaktypeId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toZaaktypeOverzicht()
            ?: error("Zaaktype with id $zaaktypeId not found")

    private fun toResultaat(resultaatId: String) =
        resultaatRepository.findById(resultaatId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toResultaat()
            ?: error("Resultaat with id $resultaatId not found")

    private fun toZaakstatus(statusId: String) =
        zaakStatusRepository.findById(statusId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toZaakstatus()
            ?: error("Zaakstatus with id $statusId not found")

    private fun toBesluittype(besluittypeId: String) =
        besluittypeRepository.findById(besluittypeId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toBesluittype()
            ?: error("Besluittype with id $besluittypeId not found")

    private fun toZaakBetrokkene(zaakBetrokkeneEntity: ZaakBetrokkeneEntity) = ZaakBetrokkene(
        indCorrespondentie = zaakBetrokkeneEntity.indCorrespondentie,
        startdatum = zaakBetrokkeneEntity.startdatum,
        typeBetrokkenheid = ZaakBetrokkenetype.valueOf(zaakBetrokkeneEntity.zaakBetrokkeneType.lowercase()),
        toelichting = zaakBetrokkeneEntity.toelichting,
        betrokkene = subjectRepository.findById(zaakBetrokkeneEntity.betrokkeneId)
            ?.toSubject()
            ?: error("Betrokkene with id ${zaakBetrokkeneEntity.betrokkeneId} not found")
    )

    private fun toBesluit(besluitEntity: BesluitEntity) =
        Besluit(
            functioneleIdentificatie = besluitEntity.functioneelId,
            besluittype = toBesluittype(besluitEntity.besluittypeId),
            besluitDatum = besluitEntity.besluitdatum,
            functioneleIdentificatieDocument = besluitEntity.document?.idFunctioneel,
            documenttype = besluitEntity.documenttypeId?.let { documentConverter.toDocumenttype(it) },
            ingangsdatum = besluitEntity.ingangsdatum,
            vervaldatum = besluitEntity.vervaldatum,
            berekenVervaldatum = besluitEntity.berekenVervaldatum,
            reactiedatum = besluitEntity.reactiedatum,
            publicatiedatum = besluitEntity.publicatiedatum,
            toelichting = besluitEntity.toelichting,
            procestermijnInMaanden = besluitEntity.procestermijnInMaanden,
        )
}

fun ZaakStatusEntity.toZaakstatus() = Zaakstatus(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
    uitwisselingscode = uitwisselingsCode,
    externeNaam = externeNaam,
)

fun ResultaatEntity.toResultaat() = Resultaat(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
    uitwisselingscode = uitwisselingsCode,
)

private fun BesluitcategorieEntity.toBesluitcategory() = Besluitcategorie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)

fun BesluittypeEntity.toBesluittype() = Besluittype(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
    besluitcategorie = besluitcategorie.toBesluitcategory(),
    reactietermijnInDagen = reactietermijnInDagen,
    publicatieIndicatie = publicatieIndicatie,
    publicatietekst = publicatietekst,
    publicatietermijnInDagen = publicatietermijnInDagen,
)

private fun BetaalgegevensEntity.toBetaalgegevens() = Betaalgegevens(
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

private fun ArchiveergegevensEntity.toArchiveergegevens() = ArchiveerGegevens(
    reviewTermijnEinddatum = reviewtermijnEinde,
    bewaartermijnEinddatum = bewaartermijnEinde,
    bewaartermijnWaardering = bewaartermijnWaardering?.toBewaartermijnWaardering(),
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
        null -> null
        else -> error("Invalid OverbrengenType: $overbrengenType")
    },
    overgebrachteGegevens = overgebrachteGegevensEntity?.toOvergebrachteGegevens(),
    zaaktypeNaam = zaaktypeNaam,
)

private fun OvergebrachteGegevensEntity.toOvergebrachteGegevens() = OvergebrachteGegevens(
    overgebrachtOp = overgebrachtOp,
    overgebrachtDoor = overgebrachtDoor,
    overgebrachtNaar = overgebrachtNaar,
)

private fun ZaakHistorieEntity.toZaakHistorie() = ZaakHistorie(
    wijzigingDatum = datumwijziging,
    gewijzigdDoor = gewijzigddoor,
    oudeWaarde = oudewaarde,
    nieuweWaarde = nieuwewaarde,
    toelichting = toelichting,
    typeWijziging = ZaakHistorieTypeWijziging.valueOf(typeWijziging.lowercase()),
    nieuweWaardeExtern = nieuweWaardeExtern,
)

private fun ZaakNotitieEntity.toZaakNotitie() = ZaakNotitie(
    medewerker = medewerkerId,
    datumTijd = datumTijd.toZonedDateTime(),
    notitie = notitie,
)

private fun ZaakBAGObjectEntity.toBAGObject() = BAGObject(
    bagObjectId = bagObjectId,
)

private fun ZaakZaakEntity.toZaakZaakKoppeling() = ZaakZaakKoppeling(
    dossierEigenaar = dossierEigenaar, gekoppeldeZaak = zaak.functioneelId, relatietype = when (relatietypeId) {
        "HZ" -> ZaakRelatietype.hoofdzaak
        "DZ" -> ZaakRelatietype.deelzaak
        "GZ" -> ZaakRelatietype.gerelateerde_zaak
        "VAZ" -> ZaakRelatietype.voorafgaande_zaak
        "VVZ" -> ZaakRelatietype.vervolgzaak
        else -> error("Invalid relatietypeId: $relatietypeId")
    }
)

fun String.toBewaartermijnWaardering() =
    when (this) {
        "B" -> BewaartermijnWaardering.bewaar
        "V" -> BewaartermijnWaardering.vernietig
        else -> error("Invalid BewaartermijnWaardering: $this")
    }

