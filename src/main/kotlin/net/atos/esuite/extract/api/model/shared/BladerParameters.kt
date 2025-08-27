package net.atos.esuite.extract.api.model.shared

import jakarta.ws.rs.QueryParam
import net.atos.esuite.extract.api.validation.ValidNonNegativeInteger
import org.eclipse.microprofile.openapi.annotations.media.Schema


const val DEFAULT_PAGE_SIZE = 100

class BladerParameters {

    @QueryParam("page")
    @Schema(description = "Gewenste pagina; start bij 0", defaultValue = "0", implementation = Int::class)
    @ValidNonNegativeInteger
    var page: String? = null

    @QueryParam("page_size")
    @Schema(description = "Maximum aantal items per pagina", defaultValue = "$DEFAULT_PAGE_SIZE", implementation = Int::class)
    @ValidNonNegativeInteger
    var pageSize: String? = null
}
