package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Besluittype(
    naam: String,
    omschrijving: String?,

    @field:Schema(description = "Besluit categorie")
    val besluitcategorie: Besluitcategorie,

    @field:Schema(description = "Reactietermijn in dagen", required = true)
    val reactietermijnInDagen: Int,

    @field:Schema(description = "Publicatie indicatie", required = true)
    val publicatieIndicatie: Boolean,

    @field:Schema(description = "Publicatietekst")
    val publicatietekst: String?,

    @field:Schema(description = "Publicatie termijn in dagen")
    val publicatietermijnInDagen: Int?,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving
)
