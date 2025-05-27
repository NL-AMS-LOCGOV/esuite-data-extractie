package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate
import java.time.ZonedDateTime

class ZaakOverzicht(
    @field:Schema(description = "Zaaknummer in e-Suite", maxLength = 128)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Zaaktype")
    val zaaktype: Zaaktype,

    @field:Schema(description = "Is zaak open (nog niet beëindigd)", required = true)
    val open: Boolean,
)
