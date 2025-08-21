package net.atos.esuite.extract.model.zaak

import org.eclipse.microprofile.openapi.annotations.media.Schema

class ZaakOverzicht(
    @field:Schema(description = "Zaaknummer in e-Suite", maxLength = 128)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Is zaak open (nog niet beëindigd)", required = true)
    val open: Boolean,
)
