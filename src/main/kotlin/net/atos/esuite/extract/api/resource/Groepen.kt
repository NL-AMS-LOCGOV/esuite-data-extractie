package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.api.convert.identity.toGroep
import net.atos.esuite.extract.api.convert.identity.toGroepOverzicht
import net.atos.esuite.extract.api.convert.shared.toPage
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.model.shared.Results
import net.atos.esuite.extract.api.model.shared.ValidatieFouten
import net.atos.esuite.extract.db.identity.repository.GroepRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import org.hibernate.validator.constraints.Length

@Path("groepen")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
class Groepen(
    private val groepRepository: GroepRepository,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "groep_list", summary = "Lijst van groep overzichten opvragen")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "400", description = "Bad Request",
        content = [Content(schema = Schema(implementation = ValidatieFouten::class))]
    )
    fun groepList(@BeanParam @Valid bladerParameters: BladerParameters) =
        with(groepRepository.findAll().page(bladerParameters.toPage())) {
            Results(results = list().map { it.toGroepOverzicht() }, count(), hasPreviousPage(), hasNextPage())
        }

    @GET
    @Path("{naam}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "groep_read", summary = "Een specifieke groep opvragen")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun groepRead(
        @PathParam("naam")
        @Schema(description = "Naam van groep", maxLength = 128)
        @Length(max = 128, message = "Naam mag niet langer zijn dan 128 tekens")
        naam: String
    ) =
        groepRepository.findByNaam(naam)
            ?.toGroep()
            ?: throw NotFoundException("Groep with naam '$naam' not found'")
}
