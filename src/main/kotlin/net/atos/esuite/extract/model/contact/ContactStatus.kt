package net.atos.esuite.extract.model.contact

import net.atos.esuite.extract.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class ContactStatus(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Type status")
    val type: ContactStatusType?,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)

