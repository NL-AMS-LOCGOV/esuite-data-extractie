package net.atos.esuite.extract.api.model.identity

import org.eclipse.microprofile.openapi.annotations.media.Schema

class AfdelingOverzicht(

    @field:Schema(description = "Naam van afdeling", maxLength = 128, uniqueItems = true)
    val naam: String,
)
