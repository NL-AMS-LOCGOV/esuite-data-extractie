package net.atos.esuite.extract.api.model.document

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Taal(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Functionele id: Code van de taal conform de ISO 639-2/B standaard", maxLength = 3)
    val functioneelId: String,

) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
