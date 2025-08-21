package net.atos.esuite.extract.api.model.zaak

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Zaaktype(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Functionele identificatie van zaaktype", maxLength = 128)
    val functioneleIdentificatie: String,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)

