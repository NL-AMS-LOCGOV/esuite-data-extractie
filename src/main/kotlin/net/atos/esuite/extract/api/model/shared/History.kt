package net.atos.esuite.extract.api.model.shared

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

abstract class History(
    @field:Schema(description = "Datum waarop wijziging heeft plaatsgevonden", implementation = LocalDate::class, required = false)
    val wijzigingDatum: LocalDate?,

    @field:Schema(description = "Volledige naam van gebruiker die wijziging heeft doorgevoerd", maxLength = 128, required = false)
    val gewijzigdDoor: String?,

    @field:Schema(description = "Oude waarde", required = false)
    val oudeWaarde: String?,

    @field:Schema(description = "Nieuwe waarde", required = false)
    val nieuweWaarde: String?,

    @field:Schema(description = "Toelichting of reden wijziging", required = false)
    val toelichting: String?,
)
