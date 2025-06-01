package net.atos.esuite.extract.model.shared

import org.eclipse.microprofile.openapi.annotations.media.Schema

open class Results<T>(
    results: List<T>,
    count: Int,
    page: Int,
    pageSize: Int,
) {
    @field:Schema(description = "Totaal aantal items", required = true)
    val count: Int = count

    @field:Schema(description = "Vorige pagina met items")
    val previousPage: Int? = if (page > 0) page - 1 else null

    @field:Schema(description = "Volgende pagina met items")
    val nextPage: Int? = if (count > (page + 1) * pageSize) page + 1 else null

    @field:Schema(description = "Items in de huidige pagina")
    val results: List<T> = results
}
