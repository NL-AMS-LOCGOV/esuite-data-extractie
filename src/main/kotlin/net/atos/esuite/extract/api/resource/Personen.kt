package net.atos.esuite.extract.api.resource

import jakarta.validation.constraints.NotNull
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.api.convert.basisgegevens.toPersoon
import net.atos.esuite.extract.api.model.basisgegevens.Persoon
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.model.shared.ValidatieFouten
import net.atos.esuite.extract.api.validation.ValidBSN
import net.atos.esuite.extract.db.repository.basisgegevens.PersoonRepository
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
    @Operation(operationId = "persoon_list", summary = "Personen opvragen op basis van BSN")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "400", description = "Bad Request",
        content = [Content(schema = Schema(implementation = ValidatieFouten::class))]
    )
    fun persoonList(
        @QueryParam("bsn")
        @Schema(description = "Burgerservicenummer", minLength = 9, maxLength = 9, required = true)
        @ValidBSN
        @NotNull(message = "BSN is a required field")
        bsn: String
    ): List<Persoon> {
        return persoonRepository.findByBSN(bsn).map { it.toPersoon() }
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
