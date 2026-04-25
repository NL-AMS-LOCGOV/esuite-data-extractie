package net.atos.esuite.extract.api.model.besluit

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Besluittype(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Besluit categorie")
    val besluitcategorie: Besluitcategorie,

    @field:Schema(description = "Reactietermijn in dagen")
    val reactietermijnInDagen: Int,

    @field:Schema(description = "Publicatie indicatie")
    val publicatieIndicatie: Boolean,

    @field:Schema(description = "Publicatietekst", required = false)
    val publicatietekst: String?,

    @field:Schema(description = "Publicatie termijn in dagen", required = false)
    val publicatietermijnInDagen: Int?,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
