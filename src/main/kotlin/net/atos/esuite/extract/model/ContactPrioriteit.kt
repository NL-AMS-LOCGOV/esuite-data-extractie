package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class ContactPrioriteit(
    naam: String,
    omschrijving: String?,

    @field:Schema(description = "Aantal dagen maximale doorlooptijd", required = true)
    val dagen: Int,

) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
)
