package net.atos.esuite.extract.api.model.shared

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Results<T>(
    @field:Schema(description = "Reslultaten op huidige pagina")
    val results: List<T>,

    @field:Schema(description = "Totaal aantal", required = true)
    val count: Long,

    @field:Schema(description = "Is er een vorige pagina", required = true)
    val previousPage: Boolean,

    @field:Schema(description = "Is er een volgende pagina", required = true)
    val nextPage: Boolean,
)
