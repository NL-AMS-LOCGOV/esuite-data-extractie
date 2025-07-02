package net.atos.esuite.extract.model.basisgegevens

import net.atos.esuite.extract.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Rechtsvorm(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Code", maxLength = 2)
    val code: String,

    @field:Schema(description = "Naam Rechtsvorm uit Nieuw HandelsRegister", uniqueItems = true)
    val naamNhr: String?,
) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
