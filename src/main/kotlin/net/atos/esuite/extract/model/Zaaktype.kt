package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Zaaktype(
    naam: String,
    omschrijving: String?,

    @field:Schema(description = "Functionele identificatie van zaaktype", maxLength = 128)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Is zaaktype actief", required = true)
    val actief: Boolean,

    ) : AbstractReferentie(
    naam = naam,
    omschrijving = omschrijving
)

