package net.atos.esuite.extract.model.basisgegevens

import net.atos.esuite.extract.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Land(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "GBA landcode", maxLength = 10)
    val gbaCode: String,

) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
