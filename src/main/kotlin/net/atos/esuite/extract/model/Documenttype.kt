package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Documenttype(
    naam: String,
    omschrijving: String?,

    @field:Schema(description = "Aanduiding documentcategorie", maxLength = 64)
    val documentcategorie: String?,

    @field:Schema(description = "Default publicatieniveau")
    val publicatieniveau: DocumentPublicatieniveau

) : Referentie(
    naam = naam,
    omschrijving = omschrijving
)
