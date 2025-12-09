package net.atos.esuite.extract.api.model.document

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class DocumentStatus(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Document status bepaald dat het document een nieuw of definitief document is")
    val type: DocumentStatusType?

) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
