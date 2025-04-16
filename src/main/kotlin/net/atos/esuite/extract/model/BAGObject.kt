package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class BAGObject(
    @field:Schema(description = "Identificatie van BAG object", maxLength = 128)
    val bagObjectId: String,
)
