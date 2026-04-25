package net.atos.esuite.extract.api.model.identity

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Afdeling(

    @field:Schema(description = "Naam van afdeling", maxLength = 128, uniqueItems = true)
    val naam: String,

    @field:Schema(description = "Interne code van afdeling", maxLength = 128, required = false)
    val code: String?,

    @field:Schema(description = "Omschrijving van afdeling")
    val omschrijving: String,

    @field:Schema(description = "Gebruikersnaam van hoofd van afdeling", maxLength = 128, required = false)
    val afdelingshoofd: String?,

    @field:Schema(maxLength = 64, pattern = "E-mailadres van afdeling", required = false)
    val emailadres: String?,

    @field:Schema(description = "Is afdeling actief")
    val actief: Boolean,

    @field:Schema(description = "Gebruikersnamen van medewerkers in afdeling")
    val medewerkers: Set<String>,
)
