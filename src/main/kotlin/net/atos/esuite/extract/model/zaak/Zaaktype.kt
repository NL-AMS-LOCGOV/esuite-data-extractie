package net.atos.esuite.extract.model.zaak

import net.atos.esuite.extract.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Zaaktype(
    naam: String,
    omschrijving: String?,

    @field:Schema(description = "Functionele identificatie van zaaktype", maxLength = 128)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Is zaaktype actief", required = true)
    val actief: Boolean,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving
)

