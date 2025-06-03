package net.atos.esuite.extract.resource

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("documenten")
class Documenten {

    @GET
    @Path("inhoud/{bestandsId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "document_inhoud_read", summary = "Inhoud van een document ophalen")
    @APIResponse(responseCode = "200", description = "OK")
    fun documentInhoudRead(@PathParam("bestandsId") bestandsId: String): Response {
        // ToDo: Inhoud van document ophalen
        return ok().build()
    }
}
