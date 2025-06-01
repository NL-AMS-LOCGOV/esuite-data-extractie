package net.atos.esuite.extract.converter.zaak

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.converter.basisgegevens.toSubject
import net.atos.esuite.extract.converter.document.DocumentConverter
import net.atos.esuite.extract.converter.toKanaal
import net.atos.esuite.extract.converter.toZonedDateTime
import net.atos.esuite.extract.entity.zakenmagazijn.*
import net.atos.esuite.extract.model.besluit.Besluit
import net.atos.esuite.extract.model.zaak.Zaak
import net.atos.esuite.extract.model.zaak.ZaakBetrokkene
import net.atos.esuite.extract.model.zaak.ZaakBetrokkenetype
import net.atos.esuite.extract.model.zaak.ZaakOverzicht
import net.atos.esuite.extract.repository.*
import net.atos.esuite.extract.repository.basisgegevens.SubjectRepository
import net.atos.esuite.extract.repository.zaak.BesluittypeRepository
import net.atos.esuite.extract.repository.zaak.ResultaatRepository
import net.atos.esuite.extract.repository.zaak.ZaakRepository.Companion.ZAAKTYPE_ID_PREFIX
import net.atos.esuite.extract.repository.zaak.ZaakStatusRepository
import net.atos.esuite.extract.repository.zaak.ZaaktypeRepository
import kotlin.error

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
            geolocatie = null, // ToDo: Converteer geo gegevens
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
            zaaktype = toZaaktype(zaakEntity.zaaktypeId),
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
            zaaktype = toZaaktype(zaakEntity.zaaktypeId),
            zaakEntity.einddatum == null,
        )

    private fun toZaaktype(zaaktypeId: String) =
        zaaktypeRepository.findById(zaaktypeId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toZaaktype()
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

