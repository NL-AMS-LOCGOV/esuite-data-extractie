package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class ZaakRelatietype (
    @field:Schema(description = "Naam van relatie van zaak met gekoppelde zaak", maxLength = 255)
    val naam: String,

    @field:Schema(description = "Omschrijving van relatie van zaak met gekoppelde zaak")
    val omschrijving: String,

    @field:Schema(description = "Indicatie of zaak leidend in relatie is", required = true)
    val indicatieHoofdrelatie: Boolean,

    @field:Schema(description = "Naam van relatie van gekoppelde zaak met zaak", maxLength = 255)
    val inverseNaam: String,

    @field:Schema(description = "Omschrijving van relatie van gekoppelde zaak met zaak")
    val inverseOmschrijving: String,
    )
