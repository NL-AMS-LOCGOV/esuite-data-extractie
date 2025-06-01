package net.atos.esuite.extract.model.shared

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Kanaal(
    naam: String,
    omschrijving: String?
) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
)
