package net.atos.esuite.extract.api.model.zaak

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Zaakstatus(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(
        description = "Code welke gebruikt wordt voor het uitwisselen van zaak informatie naar externe systemen zoals bijvoorbeeld via StUF-ZKN-DMS",
        maxLength = 255
    )
    val uitwisselingscode: String,

    @field:Schema(
        description = "Naam van status zoals deze getoond wordt in het publieke deel (burger en bedrijven loket) van de e=Suite",
        maxLength = 255
    )
    val externeNaam: String?,

    @field:Schema(description = "Geeft aan of status gebruikt kan worden bij starten van zaak.", required = true)
    val start: Boolean,

    @field:Schema(description = "Geeft aan of status gebruikt kan worden bij beeindigen van zaak.", required = true)
    val eind: Boolean,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
