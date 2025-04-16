package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Kanaal(
    @field:Schema(description = "Naam van kanaal", maxLength = 255)
    val naam: String,

    @field:Schema(description = "Omschrijving van kanaal")
    val omschrijving: String?,
)
