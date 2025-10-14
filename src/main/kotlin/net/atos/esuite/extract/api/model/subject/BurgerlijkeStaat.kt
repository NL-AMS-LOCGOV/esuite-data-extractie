package net.atos.esuite.extract.api.model.subject

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class BurgerlijkeStaat(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "GBA landcode", maxLength = 1)
    val gbaCode: String,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
