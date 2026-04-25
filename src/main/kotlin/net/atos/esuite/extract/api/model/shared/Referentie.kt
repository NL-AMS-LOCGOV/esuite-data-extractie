package net.atos.esuite.extract.api.model.shared

import org.eclipse.microprofile.openapi.annotations.media.Schema

abstract class Referentie(
    
    @field:Schema(description = "Naam", maxLength = 255, uniqueItems = true)
    val naam: String,

    @field:Schema(description = "Omschrijving", required = false)
    val omschrijving: String?,

    @field:Schema(description = "Actief")
    val actief: Boolean,
)
