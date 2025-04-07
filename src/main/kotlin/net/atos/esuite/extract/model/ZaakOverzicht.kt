package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class ZaakOverzicht(
    @Schema(description = "Zaaknummer in e-Suite", maxLength = 128)
    val functioneleIdentificatie: String,

    @Schema(description = "Naam van zaaktype", maxLength = 255)
    val zaaktypeNaam: String,
    )


