package net.atos.esuite.extract.model.contact

import net.atos.esuite.extract.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Contacttype(
    naam: String,
    omschrijving: String?,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
)
