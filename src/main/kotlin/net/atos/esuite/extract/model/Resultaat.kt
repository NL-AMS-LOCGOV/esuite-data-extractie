package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Resultaat(
    naam: String,
    omschrijving: String?,

    @field:Schema(
        description = "Code welke gebruikt wordt voor het uitwisselen van zaak informatie naar externe systemen zoals bijvoorbeeld via StUF-ZKN-DMS",
        maxLength = 255
    )
    val uitwisselingscode: String,
) : AbstractReferentie(
    naam = naam,
    omschrijving = omschrijving,
)


