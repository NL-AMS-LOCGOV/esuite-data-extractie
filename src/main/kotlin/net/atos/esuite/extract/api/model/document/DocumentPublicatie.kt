package net.atos.esuite.extract.api.model.document

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class DocumentPublicatie(

    @field:Schema(description = "Bestemming van publicatie. Altijd gelijk aan 'berichtenbox'", defaultValue = "berichtenbox")
    val bestemming: String = "berichtenbox",

    @field:Schema(description = "Datum waarop document versie is gepubliceerd", implementation = LocalDate::class)
    val publicatiedatum: LocalDate,
)

