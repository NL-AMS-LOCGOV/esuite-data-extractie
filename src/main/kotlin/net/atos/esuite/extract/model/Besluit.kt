package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class Besluit (
    @field:Schema(description = "", implementation = LocalDate::class)
    val besluitDatum: LocalDate,

    // ToDo: Inhoud toevoegen
)
