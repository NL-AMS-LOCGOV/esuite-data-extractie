package net.atos.esuite.extract.model.identity

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Rol(

    @field:Schema(description = "Naam van rol", maxLength = 128)
    val naam: String,

    @field:Schema(description = "Omschrijving van rol")
    val omschrijving: String,

    @field:Schema(description = "Is rol actief", required = true)
    val actief: Boolean,
)
