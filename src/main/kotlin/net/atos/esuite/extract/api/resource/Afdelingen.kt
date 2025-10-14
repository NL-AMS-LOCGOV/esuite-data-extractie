package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.api.convert.identity.toAfdeling
import net.atos.esuite.extract.api.convert.identity.toAfdelingOverzicht
import net.atos.esuite.extract.api.convert.shared.toPage
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.model.shared.Results
import net.atos.esuite.extract.api.model.shared.ValidatieFouten
import net.atos.esuite.extract.db.identity.repository.AfdelingRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import org.hibernate.validator.constraints.Length

@Path("afdelingen")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
class Afdelingen(
    private val afdelingRepository: AfdelingRepository,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "afdeling_list", summary = "Lijst van afdeling overzichten opvragen")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "400", description = "Bad Request",
        content = [Content(schema = Schema(implementation = ValidatieFouten::class))]
    )
    fun afdelingList(@BeanParam @Valid bladerParameters: BladerParameters) =
        with(afdelingRepository.findAll().page(bladerParameters.toPage())) {
            Results(list().map { it.toAfdelingOverzicht() }, count(), hasPreviousPage(), hasNextPage())
        }

    @GET
    @Path("{naam}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "afdeling_read", summary = "Een specifieke afdeling opvragen")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun afdelingRead(
        @PathParam("naam")
        @Schema(description = "Naam van afdeling", maxLength = 128)
        @Length(max = 128, message = "Naam mag niet langer zijn dan 128 tekens")
        naam: String
    ) =
        afdelingRepository.findByNaam(naam)
            ?.toAfdeling()
            ?: throw NotFoundException("Afdeling with naam '$naam' not found")
}
