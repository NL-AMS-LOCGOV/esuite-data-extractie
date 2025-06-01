package net.atos.esuite.extract.model.shared

import jakarta.ws.rs.QueryParam
import org.eclipse.microprofile.openapi.annotations.media.Schema

class BladerParameters {
    @QueryParam("page")
    @Schema(defaultValue = "0")
    var page: Int = 0

    @QueryParam("page_size")
    @Schema(description = "Maximum aantal items per pagina", defaultValue = "100")
    var pageSize: Int = 100

}
