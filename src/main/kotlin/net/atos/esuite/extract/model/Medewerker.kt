package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Medewerker(
    @field:Schema(description = "Gebruikersnaam van medewerker", maxLength = 64)
    val gebruikersnaam: String,

    @field:Schema(description = "Volledige naam van medewerker", maxLength = 128)
    val volledigeNaam: String,
)
