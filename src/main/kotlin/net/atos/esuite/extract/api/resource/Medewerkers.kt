package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.api.convert.identity.toMedewerker
import net.atos.esuite.extract.api.convert.identity.toMedewerkerOverzicht
import net.atos.esuite.extract.api.convert.shared.toPage
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.model.shared.Results
import net.atos.esuite.extract.api.model.shared.ValidatieFouten
import net.atos.esuite.extract.db.repository.identity.MedewerkerRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("medewerkers")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
class Medewerkers(
    private val medewerkerRepository: MedewerkerRepository,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "medewerker_list", summary = "Lijst van medewerker overzichten opvragen")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "400", description = "Bad Request",
        content = [Content(schema = Schema(implementation = ValidatieFouten::class))]
    )
    fun medewerkerList(@BeanParam @Valid bladerParameters: BladerParameters) =
        with(medewerkerRepository.findAll().page(bladerParameters.toPage())) {
            Results(list().map { it.toMedewerkerOverzicht() }, count(), hasPreviousPage(), hasNextPage())
        }

    @GET
    @Path("{gebruikersnaam}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "medewerker_read", summary = "Een specifieke medewerker opvragen")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun medewerkerRead(@PathParam("gebruikersnaam") gebruikersnaam: String) =
        medewerkerRepository.findByGebruikersnaam(gebruikersnaam)
            ?.toMedewerker()
            ?: throw NotFoundException("Medewerker with gebruikersnaam '$gebruikersnaam' not found")
}
