package net.atos.esuite.extract.model.basisgegevens

import net.atos.esuite.extract.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

@Schema(allOf = [Referentie::class])
class Nationaliteit(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Reden verkrijging nationaliteit", maxLength = 255)
    val redenVerkrijging: String?,

    @field:Schema(description = "Datum verkrijging nationaliteit", implementation = LocalDate::class)
    val datumVerkrijging: LocalDate?,

    @field:Schema(description = "GBA code", maxLength = 10)
    val gbaCode: String,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
