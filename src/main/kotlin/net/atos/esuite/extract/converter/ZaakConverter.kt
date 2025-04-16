package net.atos.esuite.extract.converter

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.zakenmagazijn.*
import net.atos.esuite.extract.model.*
import net.atos.esuite.extract.repository.*
import net.atos.esuite.extract.repository.ZaakRepository.Companion.ZAAKTYPE_ID_PREFIX

@ApplicationScoped
class ZaakConverter(
    private val zaakStatusRepository: ZaakStatusRepository,
    private val resultaatRepository: ResultaatRepository,
    private val zaaktypeRepository: ZaaktypeRepository,
    private val documentConverter: DocumentConverter,
) {
    fun toZaak(zaakEntity: ZaakEntity) =
        Zaak(
            aangemaaktDoor = zaakEntity.aangemaaktDoorId,
            afdeling = zaakEntity.afdelingId,
            archiveerGegevens = zaakEntity.archiveergegevens?.toArchiveergegevens(),
            bagObjecten = zaakEntity.gekoppeldeBAGObjecten.map { it.toBAGObject() }.ifEmpty { null },
            behandelaar = zaakEntity.behandelaarId,
            besluiten = zaakEntity.besluiten.map { it.toBesluit() }.ifEmpty { null },
            betaalgegevens = zaakEntity.betaalgegevens?.toBetaalgegevens(),
            betrokkenen = zaakEntity.betrokkenen.map { it.toZaakBetrokkene() }.ifEmpty { null },
            contacten = zaakEntity.contacten.map { it.toZaakContact() }.ifEmpty { null },
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
            isGeautoriseerdVoorMedewerkers = zaakEntity.autorisatie,
            isHeropend = zaakEntity.indicatieHeropend,
            isIntake = zaakEntity.indicatieIntake,
            isProcesGestart = zaakEntity.procesGestart,
            isVernietiging = zaakEntity.inVernietiging,
            isVertrouwelijk = zaakEntity.indicatieVertrouwelijk,
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
            zaakdata = zaakEntity.zaakdataElementen.map { it.toZaakData() }.ifEmpty { null },
            zaaktype = toZaaktype(zaakEntity.zaaktypeId),
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
}

