package net.atos.esuite.extract.api.resource

import jakarta.validation.constraints.NotNull
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.api.convert.toPersoon
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.model.shared.ValidatieFouten
import net.atos.esuite.extract.api.validation.ValidBSN
import net.atos.esuite.extract.api.validation.ValidNonNegativeInteger
import net.atos.esuite.extract.db.basisgegevens.repository.PersoonRepository
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
    @Operation(operationId = "persoon_read_bsn", summary = "Persoon opvragen op basis van BSN")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "400", description = "Bad Request",
        content = [Content(schema = Schema(implementation = ValidatieFouten::class))]
    )
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun persoonReadBSN(
        @QueryParam("bsn")
        @Schema(description = "Burgerservicenummer", minLength = 9, maxLength = 9, required = true)
        @ValidBSN
        @NotNull(message = "BSN is a required field")
        bsn: String
    ) =
        persoonRepository.findByBSN(bsn)
            ?.toPersoon()
            ?: throw NotFoundException("Persoon with BSN '$bsn' not found")

    @GET
    @Path("{identifier}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "persoon_read", summary = "Een specifiek persoon opvragen op basis van interne identifier")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun persoonRead(
        @PathParam("identifier")
        @Schema(description = "Interne identifier van persoon", implementation = Long::class)
        @ValidNonNegativeInteger
        identifier: String
    ) =
        persoonRepository.findById(identifier.toLong())
            ?.toPersoon()
            ?: throw NotFoundException("Persoon with identifier '$identifier' not found")
}
