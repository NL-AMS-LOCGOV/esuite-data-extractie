package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Besluitcategorie (
    naam: String,
    omschrijving: String?,
) : AbstractReferentie(
    naam = naam,
    omschrijving = omschrijving
)
