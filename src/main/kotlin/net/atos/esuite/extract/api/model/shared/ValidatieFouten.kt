package net.atos.esuite.extract.api.model.shared

import jakarta.json.bind.annotation.JsonbPropertyOrder
import org.eclipse.microprofile.openapi.annotations.media.Schema

@JsonbPropertyOrder("melding", "fouten")
class ValidatieFouten(
    @field:Schema(description = "Validatie fout(en)")
    val fouten: List<ValidatieFout>,
) : Fout(melding = "Validatie fout(en)")
