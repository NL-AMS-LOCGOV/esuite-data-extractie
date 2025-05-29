package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate
import java.time.ZonedDateTime

class MedewerkerOverzicht(

    @field:Schema(description = "Gebruikersnaam van medewerker", maxLength = 128, uniqueItems = true)
    val gebruikersnaam: String,

    @field:Schema(description = "Volledige naam van medewerker", maxLength = 128)
    val volledigeNaam: String,
)
