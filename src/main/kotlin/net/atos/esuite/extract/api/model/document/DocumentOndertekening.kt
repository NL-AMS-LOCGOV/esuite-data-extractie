package net.atos.esuite.extract.api.model.document

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate
import java.time.ZonedDateTime

class DocumentOndertekening(
    @field:Schema(description = "Titel van document bij ondertekening", maxLength = 256)
    val documentTitel: String,

    @field:Schema(description = "Ondertekenaar van document versie", maxLength = 128)
    val ondertekenaar: String,

    @field:Schema(description = "Datum waarop document versie werd ondertekend", implementation = ZonedDateTime::class)
    val ondertekenDatum: ZonedDateTime,

    @field:Schema(
        description = "Datum waarop ondertekening van document versie werd aangemaakt",
        implementation = LocalDate::class
    )
    val creatieDatum: LocalDate,

    @field:Schema(description = "Opmerkingen over ondertekening van document versie")
    val opmerking: String?,

    @field:Schema(description = "Ondertekening is wel of niet gemandateerd", required = true)
    val gemandateerd: Boolean,
)

