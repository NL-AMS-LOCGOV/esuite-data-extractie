package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.ZonedDateTime

class OvergebrachteGegevens (
    @field:Schema(description = "")
    val overgebrachtOp: ZonedDateTime,

    @field:Schema(description = "")
    val overgebrachtDoor: Medewerker,

    @field:Schema(description = "", maxLength = 255)
    val overgebrachtNaar: String,
    )
