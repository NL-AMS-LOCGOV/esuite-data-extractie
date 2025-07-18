package net.atos.esuite.extract.model.basisgegevens

import net.atos.esuite.extract.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Nevenactiviteit(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Code", maxLength = 7)
    val code: String?,
) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
