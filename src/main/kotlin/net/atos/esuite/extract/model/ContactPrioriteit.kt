package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class ContactPrioriteit(
    naam: String,
    omschrijving: String?,

    @field:Schema(description = "Aantal dagen maximale doorlooptijd", required = true)
    val dagen: Int,

) : AbstractReferentie(
    naam = naam,
    omschrijving = omschrijving,
)
