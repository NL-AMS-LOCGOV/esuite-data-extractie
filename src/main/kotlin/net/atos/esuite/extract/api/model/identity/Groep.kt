package net.atos.esuite.extract.api.model.identity

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Groep(

    @field:Schema(description = "Naam van groep", maxLength = 128, uniqueItems = true)
    val naam: String,

    @field:Schema(description = "Interne code van groep", maxLength = 128, required = false)
    val code: String?,

    @field:Schema(description = "Omschrijving van groep")
    val omschrijving: String,

    @field:Schema(description = "Gebruikersnaam van hoofd van groep", maxLength = 128, required = false)
    val groepshoofd: String?,

    @field:Schema(maxLength = 64, pattern = "E-mailadres van groep", required = false)
    val emailadres: String?,

    @field:Schema(description = "Is groep actief")
    val actief: Boolean,

    @field:Schema(description = "Gebruikersnamen van medewerkers in groep")
    val medewerkers: Set<String>,
)
