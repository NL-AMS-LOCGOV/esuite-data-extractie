package net.atos.esuite.extract.api.model.shared

import jakarta.ws.rs.QueryParam
import net.atos.esuite.extract.api.validation.ValidNonNegativeInteger
import org.eclipse.microprofile.openapi.annotations.media.Schema


private const val DEFAULT_START_PAGE = 0
private const val DEFAULT_PAGE_SIZE = 100

class BladerParameters {

    @QueryParam("page")
    @Schema(description = "Gewenste pagina; start bij $DEFAULT_START_PAGE", defaultValue = "$DEFAULT_START_PAGE", implementation = Int::class)
    @ValidNonNegativeInteger
    private var _page: String? = null

    @QueryParam("page_size")
    @Schema(description = "Maximum aantal items per pagina", defaultValue = "$DEFAULT_PAGE_SIZE", implementation = Int::class)
    @ValidNonNegativeInteger
    private var _pageSize: String? = null

    // Int-typed views on top of the String fields
    val page: Int
        get() = _page?.toIntOrNull() ?: DEFAULT_START_PAGE

    val pageSize: Int
        get() = _pageSize?.toIntOrNull() ?: DEFAULT_PAGE_SIZE
}
