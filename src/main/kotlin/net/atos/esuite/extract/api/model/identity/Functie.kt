package net.atos.esuite.extract.api.model.identity

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Functie(

    @field:Schema(description = "Naam van functie", maxLength = 128)
    val naam: String,

    @field:Schema(description = "Omschrijving van functie")
    val omschrijving: String,

    @field:Schema(description = "Is functie actief", required = true)
    val actief: Boolean,
)
