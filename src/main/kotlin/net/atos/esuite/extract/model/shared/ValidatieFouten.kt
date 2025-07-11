package net.atos.esuite.extract.model.shared

import jakarta.json.bind.annotation.JsonbPropertyOrder
import org.eclipse.microprofile.openapi.annotations.media.Schema

@JsonbPropertyOrder("aantal", "fouten")
class ValidatieFouten(
    @field:Schema(description = "Validatie fouten")
    val fouten: List<ValidatieFout>,
    
    @field:Schema(description = "Foutmelding", required = true)
    val aantal: Int = fouten.size
)
