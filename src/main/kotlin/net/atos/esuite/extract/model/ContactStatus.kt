package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class ContactStatus(
    naam: String,
    omschrijving: String?,

    @field:Schema(description = "Type status")
    val type: ContactStatusType?,

    ) : AbstractReferentie(
    naam = naam,
    omschrijving = omschrijving,
)

