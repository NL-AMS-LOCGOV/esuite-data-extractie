package net.atos.esuite.extract.api.model.basisgegevens

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class SubjectNotitie(

    @field:Schema(description = "Datum vanaf wanneer notitie geldig is", implementation = LocalDate::class)
    val ingangsdatumGeldigheid: LocalDate?,

    @field:Schema(description = "Afdeling", maxLength = 128)
    val afdeling: String?,

    @field:Schema(description = "Groep", maxLength = 128)
    val groep: String?,

    @field:Schema(description = "Datum tot wanneer notitie geldig is", implementation = LocalDate::class)
    val einddatumGeldigheid: LocalDate?,

    @field:Schema(description = "Datum waarop notitie is aangemaakt", implementation = LocalDate::class)
    val aangemaaktOp: LocalDate,

    @field:Schema(
        description = "Volledige naam van medewerker die notitie heeft aangemaakt gevolgd door de naam van zijn primaire afdeling gescheiden door een komma en een spatie",
        maxLength = 128
    )
    val aangemaaktDoor: String,

    @field:Schema(description = "Titel van notitie", maxLength = 128)
    val titel: String,

    @field:Schema(description = "Inhoud van notitie")
    val inhoud: String,
)
