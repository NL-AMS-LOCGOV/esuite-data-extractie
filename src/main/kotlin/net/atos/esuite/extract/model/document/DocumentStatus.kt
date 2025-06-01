package net.atos.esuite.extract.model.document

import net.atos.esuite.extract.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class DocumentStatus(
    naam: String,
    omschrijving: String?
) : Referentie(
    naam = naam,
    omschrijving = omschrijving
)
