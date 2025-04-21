package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate
import java.time.ZonedDateTime

class ZaakOverzicht(
    @field:Schema(description = "Zaaknummer in e-Suite", maxLength = 128)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Zaaktype")
    val zaaktype: Zaaktype,
    )
