package net.atos.esuite.extract.converter

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.ZaakEntity
import net.atos.esuite.extract.model.*
import java.time.LocalDate
import java.time.ZonedDateTime

@ApplicationScoped
class ZaakConverter {

    fun convert(zaakEntity: ZaakEntity): Zaak {
        return Zaak(
            functioneleIdentificatie = zaakEntity.functioneelId,
            externeIdentificatie = "",
            omschrijving = "",
            redenStart = null,
            zaaktype = Zaaktype("", ""),
            isVertrouwelijk = false,
            isIntake = false,
            isHeropend = false,
            isVernietiging = false,
            isProcesGestart = true,
            behandelaar = null,
            afdeling = null,
            groep = null,
            aangemaaktDoor = Medewerker("", ""),
            kanaal = "",
            creatieTijdstip =ZonedDateTime.now(),
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
            besluiten = null,
            documenten = null,
            bagObjecten = null,
            betrokkenen = null,
            taken = null,
            gekoppeldeZaken = null,
        )
    }
}
