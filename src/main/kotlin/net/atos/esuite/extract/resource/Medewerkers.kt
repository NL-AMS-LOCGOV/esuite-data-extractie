package net.atos.esuite.extract.resource

import jakarta.ws.rs.BeanParam
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.WebApplicationException
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.converter.toMedewerker
import net.atos.esuite.extract.converter.toMedewerkerOverzicht
import net.atos.esuite.extract.model.BladerParameters
import net.atos.esuite.extract.model.Medewerker
import net.atos.esuite.extract.model.MedewerkerOverzichtResults
import net.atos.esuite.extract.repository.MedewerkerRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("/medewerkers")
class Medewerkers(
    private val medewerkerRepository: MedewerkerRepository,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "medewerker_list", summary = "Lijst van medewerker overzichten opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = MedewerkerOverzichtResults::class))]
    )
    fun medewerkerList(
        @BeanParam bladerParameters: BladerParameters
    ): Response {
        val (medewerkers, totaalAantalMedewerkers) = medewerkerRepository.list(
            bladerParameters.page,
            bladerParameters.pageSize
        )
        return ok(
            MedewerkerOverzichtResults(
                medewerkers.map { it.toMedewerkerOverzicht() },
                totaalAantalMedewerkers,
                bladerParameters.page,
                bladerParameters.pageSize,
            )
        ).build()
    }

    @GET
    @Path("{gebruikersnaam}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "medewerker_read", summary = "Een specifieke medewerker opvragen")
    @APIResponse(
        responseCode = "200",
        description = "OK",
        content = [Content(schema = Schema(implementation = Medewerker::class))]
    )
    fun medewerkerRead(@PathParam("gebruikersnaam") gebruikersnaam: String): Response {
        return ok(
            medewerkerRepository.findByGebruikersnaam(gebruikersnaam)
                ?.let { it.toMedewerker() }
                ?: throw WebApplicationException("Medewerker not found", 404)
        ).build()
    }
}
