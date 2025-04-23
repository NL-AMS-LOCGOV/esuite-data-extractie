package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

abstract class Referentie(
    @field:Schema(description = "Naam", maxLength = 255)
    val naam: String,

    @field:Schema(description = "Omschrijving")
    val omschrijving: String?,
)
