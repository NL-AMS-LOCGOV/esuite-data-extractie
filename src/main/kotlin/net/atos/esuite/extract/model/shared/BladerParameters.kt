package net.atos.esuite.extract.model.shared

import jakarta.ws.rs.QueryParam
import net.atos.esuite.extract.validation.ValidNonNegativeInteger
import org.eclipse.microprofile.openapi.annotations.media.Schema

class BladerParameters {
    
    @QueryParam("page")
    @Schema(description = "Gewenste pagina; start bij 0", defaultValue = "0", implementation = Int::class)
    @ValidNonNegativeInteger
    private var _page: String? = null

    @QueryParam("page_size")
    @Schema(description = "Maximum aantal items per pagina", defaultValue = "100", implementation = Int::class)
    @ValidNonNegativeInteger
    private var _pageSize: String? = null

    // Int-typed views on top of the String fields
    val page: Int
        get() = _page?.toIntOrNull() ?: 0

    val pageSize: Int
        get() = _pageSize?.toIntOrNull() ?: 100
}
