package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Zaaktype(
    @field:Schema(description = "Naam van zaaktype", maxLength = 255)
    val naam: String,

    @field:Schema(description = "Naam van zaaktype", maxLength = 128)
    val functioneleIdentificatie: String,
)
