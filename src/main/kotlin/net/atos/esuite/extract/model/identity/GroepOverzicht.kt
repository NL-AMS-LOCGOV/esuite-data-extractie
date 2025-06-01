package net.atos.esuite.extract.model.identity

import org.eclipse.microprofile.openapi.annotations.media.Schema

class GroepOverzicht(

    @field:Schema(description = "Naam van groep", maxLength = 128, uniqueItems = true)
    val naam: String,
)
