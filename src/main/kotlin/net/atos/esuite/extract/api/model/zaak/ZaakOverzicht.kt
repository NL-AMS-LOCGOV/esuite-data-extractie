package net.atos.esuite.extract.api.model.zaak

import org.eclipse.microprofile.openapi.annotations.media.Schema

class ZaakOverzicht(
    @field:Schema(description = "Zaaknummer in e-Suite", maxLength = 128)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Is zaak open (nog niet beëindigd)")
    val open: Boolean,

    @field:Schema(description = "Is zaak gemigreerd")
    val gemigreerd: Boolean,
)
