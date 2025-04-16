package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

abstract class AbstractHistory(
    @field:Schema(description = "Datum waarop wijziging heeft plaatsgevonden", implementation = LocalDate::class)
    val wijzigingDatum: LocalDate?,

    @field:Schema(description = "Volledige naam van gebruiker die wijziging heeft doorgevoerd", maxLength = 128)
    val gewijzigdDoor: String?,

    @field:Schema(description = "Oude waarde")
    val oudeWaarde: String?,

    @field:Schema(description = "Nieuwe waarde")
    val nieuweWaarde: String?,

    @field:Schema(description = "Toelichting of reden wijziging")
    val toelichting: String?,
)
