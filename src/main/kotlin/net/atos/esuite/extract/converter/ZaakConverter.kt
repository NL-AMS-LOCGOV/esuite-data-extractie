package net.atos.esuite.extract.converter

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.zakenmagazijn.BesluitEntity
import net.atos.esuite.extract.entity.zakenmagazijn.ReferentieResultaatEntity
import net.atos.esuite.extract.entity.zakenmagazijn.ReferentieZaakStatusEntity
import net.atos.esuite.extract.entity.zakenmagazijn.ZaakEntity
import net.atos.esuite.extract.model.*
import net.atos.esuite.extract.repository.ResultaatRepository
import net.atos.esuite.extract.repository.ZaakRepository.Companion.ZAAKTYPE_ID_PREFIX
import net.atos.esuite.extract.repository.ZaakStatusRepository
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime

@ApplicationScoped
class ZaakConverter(
    private val zaakStatusRepository: ZaakStatusRepository,
    private val resultaatRepository: ResultaatRepository,
) {
    fun toZaak(zaakEntity: ZaakEntity) =
        Zaak(
            functioneleIdentificatie = zaakEntity.functioneelId,
            externeIdentificatie = zaakEntity.externFunctioneelId,
            omschrijving = zaakEntity.omschrijving,
            redenStart = zaakEntity.redenStartZaak,
            zaaktype = Zaaktype("", ""),
            isVertrouwelijk = zaakEntity.indicatieVertrouwelijk,
            isIntake = zaakEntity.indicatieIntake,
            isHeropend = zaakEntity.indicatieHeropend,
            isVernietiging = zaakEntity.inVernietiging,
            isProcesGestart = zaakEntity.procesGestart,
            behandelaar = null,
            afdeling = null,
            groep = null,
            aangemaaktDoor = Medewerker("", ""),
            kanaal = zaakEntity.kanaal?.naam,
            creatieTijdstip = ZonedDateTime.ofInstant(zaakEntity.creatiedatum, ZoneId.of("Europe/Amsterdam")),
            wijzigTijdstip = ZonedDateTime.now(),
            startdatum = LocalDate.now(),
            streefdatum = LocalDate.now(),
            fataledatum = null,
            einddatum = null,
            status = toZaakstatus(zaakEntity.statusId),
            resultaat = zaakEntity.resultaatId?.let { toResultaat(it) },
            betaalgegevens = null,
            archiveerGegevens = null,
            geolocatie = null,
            opschorttermijn = null,
            organisatie = null,
            historie = null,
            notities = null,
            details = null,
            geautoriseerdeMedewerkers = null,
            besluiten = zaakEntity.besluiten.map { it.toBesluit() }.ifEmpty { null },
            documenten = null,
            bagObjecten = null,
            betrokkenen = null,
            taken = null,
            gekoppeldeZaken = null,
        )

    private fun toResultaat(resultaatId: String) =
        resultaatRepository.findById(resultaatId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toResultaat()
            ?: error("Resultaat with id $resultaatId not found")

    private fun toZaakstatus(statusId: String) =
        zaakStatusRepository.findById(statusId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toZaakstatus()
            ?: error("Zaakstatus with id $statusId not found")
}

private fun ReferentieZaakStatusEntity.toZaakstatus() =
    Zaakstatus(
        naam = naam,
        omschrijving = omschrijving,
        uitwisselingscode = uitwisselingsCode,
        externeNaam = externeNaam,
    )

private fun ReferentieResultaatEntity.toResultaat() =
    Resultaat(
        naam = naam,
        omschrijving = omschrijving,
        uitwisselingscode = uitwisselingsCode,
    )

private fun BesluitEntity.toBesluit() =
    Besluit(
        besluitDatum = besluitdatum
    )
