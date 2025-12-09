package net.atos.esuite.extract.api.model.document

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Documenttype(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Aanduiding documentcategorie", maxLength = 64)
    val documentcategorie: String?,

    @field:Schema(description = "Default publicatieniveau")
    val publicatieniveau: DocumentPublicatieniveau,

    @field:Schema(description = "Mogelijke documentstatussen")
    val documentstatussen: Set<Documentstatus>,

    @field:Schema(description = "Mogelijke metadata elementen")
    val metadataElementen: Set<MetadataElement>?,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
