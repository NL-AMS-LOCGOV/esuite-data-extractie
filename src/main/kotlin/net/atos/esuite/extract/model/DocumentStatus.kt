package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class DocumentStatus(
    naam: String,
    omschrijving: String?
) : Referentie(
    naam = naam,
    omschrijving = omschrijving
)
