package net.atos.esuite.extract.model.zaak

import net.atos.esuite.extract.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Resultaat(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(
        description = "Code welke gebruikt wordt voor het uitwisselen van zaak informatie naar externe systemen zoals bijvoorbeeld via StUF-ZKN-DMS",
        maxLength = 255
    )
    val uitwisselingscode: String,
) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
