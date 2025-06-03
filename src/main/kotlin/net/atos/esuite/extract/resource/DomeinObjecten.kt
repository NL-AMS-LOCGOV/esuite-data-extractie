package net.atos.esuite.extract.resource

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("domeinobjecten")
class DomeinObjecten {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "domein_object_list", summary = "Domein objecten ophalen")
    @APIResponse(responseCode = "200", description = "OK")
    fun domeinobject(
        @QueryParam("zaakFunctioneleIdentificatie")
        @Schema(description = "Zaaknummer van zaak", maxLength = 128, required = true)
        zaakFunctioneleIdentificatie: String): Response {
        // ToDo: Domein objecten ophalen
        return ok().build()
    }
}
