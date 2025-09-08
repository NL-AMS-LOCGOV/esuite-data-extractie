package net.atos.esuite.extract.api.model.taak

import net.atos.esuite.extract.api.model.document.Documenttype
import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class TaakDocument(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Document naam", maxLength = 255)
    val documentNaam: String?,

    @field:Schema(description = "Document template", maxLength = 255)
    val documentTemplate: String?,

    @field:Schema(description = "Template groep", maxLength = 255)
    val templateGroep: String?,

    @field:Schema(description = "Type document")
    val documenttype: Documenttype?,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
