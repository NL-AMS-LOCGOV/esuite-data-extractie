package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class ContactStatus(
    naam: String,
    omschrijving: String?,

    @field:Schema(description = "Type status")
    val type: ContactStatusType?,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
)

