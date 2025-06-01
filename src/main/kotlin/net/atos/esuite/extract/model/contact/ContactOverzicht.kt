package net.atos.esuite.extract.model.contact

import org.eclipse.microprofile.openapi.annotations.media.Schema

class ContactOverzicht (
    @field:Schema(description = "Functionele identificatie", maxLength = 128)
    val functioneleIdentificatie: String,
)
