package net.atos.esuite.extract.model

class Organisatie(
    naam: String,
    omschrijving: String?
) : AbstractReferentie(
    naam = naam,
    omschrijving = omschrijving,
)
