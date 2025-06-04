package net.atos.esuite.extract.model.besluit

import net.atos.esuite.extract.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Besluitcategorie (
    naam: String,
    omschrijving: String?,
    actief: Boolean,
) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
