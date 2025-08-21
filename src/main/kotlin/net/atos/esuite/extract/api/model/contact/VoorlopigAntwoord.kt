package net.atos.esuite.extract.api.model.contact

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.ZonedDateTime

class VoorlopigAntwoord(

    @field:Schema(description = "Voorlopig antwoord")
    val antwoord: String,

    @field:Schema(description = "Datum/tijd voorlopige antwoord", implementation = ZonedDateTime::class)
    val antwoordDatumTijd: ZonedDateTime,

    @field:Schema(description = "Afdeling", maxLength = 128)
    val afdeling: String?,

    @field:Schema(description = "Medewerker", maxLength = 64)
    val medewerker: String?,
)
