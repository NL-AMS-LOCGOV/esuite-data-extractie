package net.atos.esuite.extract.model.shared

import jakarta.json.bind.annotation.JsonbPropertyOrder
import org.eclipse.microprofile.openapi.annotations.media.Schema

@JsonbPropertyOrder("message", "field", "value")
class ValidatieFout (
    @field:Schema(description = "Validatie foutmelding")
    val message: String,

    @field:Schema(description = "Naam veld met foutieve waarde")
    val field: String,

    @field:Schema(description = "Foutieve waarde")
    val value: String,
)
