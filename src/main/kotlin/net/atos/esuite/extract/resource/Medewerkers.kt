package net.atos.esuite.extract.resource

import jakarta.validation.Valid
import jakarta.ws.rs.BeanParam
import jakarta.ws.rs.GET
import jakarta.ws.rs.NotFoundException
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.converter.identity.toMedewerker
import net.atos.esuite.extract.converter.identity.toMedewerkerOverzicht
import net.atos.esuite.extract.model.shared.BladerParameters
import net.atos.esuite.extract.model.identity.Medewerker
import net.atos.esuite.extract.model.identity.MedewerkerOverzichtResults
import net.atos.esuite.extract.model.shared.Fout
import net.atos.esuite.extract.repository.identity.MedewerkerRepository
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
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = MedewerkerOverzichtResults::class))]
    )
    fun medewerkerList(
        @BeanParam @Valid bladerParameters: BladerParameters
    ): Response {
        val (medewerkers, totaalAantalMedewerkers) = medewerkerRepository.listAll(
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
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = Medewerker::class))]
    )
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun medewerkerRead(@PathParam("gebruikersnaam") gebruikersnaam: String): Response {
        return ok(
            medewerkerRepository.findByGebruikersnaam(gebruikersnaam)
                ?.toMedewerker()
                ?: throw NotFoundException("Medewerker with gebruikersnaam '$gebruikersnaam' Not Found")
        ).build()
    }
}
