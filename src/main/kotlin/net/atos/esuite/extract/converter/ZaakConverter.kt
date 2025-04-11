package net.atos.esuite.extract.converter

import net.atos.esuite.extract.entity.BesluitEntity
import net.atos.esuite.extract.entity.ZaakEntity
import net.atos.esuite.extract.model.*
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime

fun ZaakEntity.toZaak() =
    Zaak(
        functioneleIdentificatie = functioneelId,
        externeIdentificatie = externFunctioneelId,
        omschrijving = omschrijving,
        redenStart = redenStartZaak,
        zaaktype = Zaaktype("", ""),
        isVertrouwelijk = indicatieVertrouwelijk,
        isIntake = indicatieIntake,
        isHeropend = indicatieHeropend,
        isVernietiging = inVernietiging,
        isProcesGestart = procesGestart,
        behandelaar = null,
        afdeling = null,
        groep = null,
        aangemaaktDoor = Medewerker("", ""),
        kanaal = kanaal?.naam,
        creatieTijdstip = ZonedDateTime.ofInstant(creatiedatum, ZoneId.of("Europe/Amsterdam")),
        wijzigTijdstip = ZonedDateTime.now(),
        startdatum = LocalDate.now(),
        streefdatum = LocalDate.now(),
        fataledatum = null,
        einddatum = null,
        status = Zaakstatus("", "", "", ""),
        resultaat = Zaakresultaat("", "", ""),
        betaalgegevens = null,
        archiveerGegevens = null,
        geolocatie = null,
        opschorttermijn = null,
        organisatie = null,
        historie = null,
        notities = null,
        details = null,
        geautoriseerdeMedewerkers = null,
        besluiten = besluiten.map { it.toBesluit() }.ifEmpty { null },
        documenten = null,
        bagObjecten = null,
        betrokkenen = null,
        taken = null,
        gekoppeldeZaken = null,
    )

private fun BesluitEntity.toBesluit() =
    Besluit(
        besluitDatum = besluitdatum
    )
