package net.atos.esuite.extract.api.model.identity

import org.eclipse.microprofile.openapi.annotations.media.Schema

class MedewerkerOverzicht(

    @field:Schema(description = "Gebruikersnaam van medewerker", maxLength = 128, uniqueItems = true)
    val gebruikersnaam: String,

    @field:Schema(description = "Volledige naam van medewerker", maxLength = 128)
    val volledigeNaam: String,
)
