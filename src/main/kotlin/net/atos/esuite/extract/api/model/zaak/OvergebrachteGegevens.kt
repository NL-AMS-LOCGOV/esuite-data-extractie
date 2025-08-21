package net.atos.esuite.extract.api.model.zaak

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class OvergebrachteGegevens (
    @field:Schema(description = "Datum waarop de zaak is overgebracht", implementation = LocalDate::class)
    val overgebrachtOp: LocalDate,

    @field:Schema(description = "Gebruikersnaam van medewerker die de zaak heeft overgebracht", maxLength = 128)
    val overgebrachtDoor: String,

    @field:Schema(description = "Locatie/instantie waarnaar de zaak is overgebracht", maxLength = 255)
    val overgebrachtNaar: String,
    )
