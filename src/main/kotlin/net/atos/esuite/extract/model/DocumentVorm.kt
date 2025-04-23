package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class DocumentVorm(
    naam: String,
    omschrijving: String?
) : Referentie(
    naam = naam,
    omschrijving = omschrijving
)
