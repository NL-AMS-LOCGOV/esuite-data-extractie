package net.atos.esuite.extract.resource

import jakarta.ws.rs.GET
import jakarta.ws.rs.NotFoundException
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.converter.basisgegevens.toPersoon
import net.atos.esuite.extract.model.basisgegevens.Persoon
import net.atos.esuite.extract.model.shared.Fout
import net.atos.esuite.extract.repository.basisgegevens.PersoonRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("personen")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
class Personen(
    private val persoonRepository: PersoonRepository,
) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "persoon_read_bsn", summary = "Een specifiek persoon opvragen op basis van de BSN")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = Persoon::class))]
    )
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun persoonReadViaBSN(
        @QueryParam("bsn")
        @Schema(description = "Burgerservicenummer", minLength = 9, maxLength = 9, required = true)
        bsn: String
    ): Response {

        return ok(
            persoonRepository.findByBSN(bsn)
                ?.toPersoon()
                ?: throw NotFoundException("Persoon with bsn '$bsn' Not Found")
        ).build()
    }

    @GET
    @Path("{identifier}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "persoon_read", summary = "Een specifiek persoon opvragen op basis van interne identifier")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = Persoon::class))]
    )
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun persoonRead(@PathParam("identifier") identifier: Long): Response {
        return ok(
            persoonRepository.findById(identifier)
                ?.toPersoon()
                ?: throw NotFoundException("Persoon with identifier '$identifier' Not Found")
        ).build()
    }
}
