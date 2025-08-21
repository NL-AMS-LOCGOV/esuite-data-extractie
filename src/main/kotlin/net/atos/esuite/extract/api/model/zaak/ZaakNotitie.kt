package net.atos.esuite.extract.api.model.zaak

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.ZonedDateTime

class ZaakNotitie(
    @field:Schema(description = "Gebruikersnaam van medewerker die notite heeft toegevoegd", maxLength = 40)
    val medewerker: String,

    @field:Schema(description = "Datum en tijd waarop notitie is toegevoegd", implementation = ZonedDateTime::class)
    val datumTijd: ZonedDateTime,

    @field:Schema(description = "Inhoud van notitie")
    val notitie: String?
)
