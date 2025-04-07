package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class ZaakHistorie (
    @field:Schema(description = "Datum laatst gewijzigd")
    val datumWijziging: LocalDate,

    )
