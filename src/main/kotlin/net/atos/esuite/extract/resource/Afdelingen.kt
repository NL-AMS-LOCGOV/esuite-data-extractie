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
import net.atos.esuite.extract.converter.identity.toAfdeling
import net.atos.esuite.extract.converter.identity.toAfdelingOverzicht
import net.atos.esuite.extract.model.identity.AfdelingOverzichtResults
import net.atos.esuite.extract.model.shared.BladerParameters
import net.atos.esuite.extract.model.identity.Medewerker
import net.atos.esuite.extract.repository.identity.AfdelingRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("afdelingen")
class Afdelingen(
    private val afdelingRepository: AfdelingRepository,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "afdeling_list", summary = "Lijst van afdeling overzichten opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = AfdelingOverzichtResults::class))]
    )
    fun afdelingList(
        @BeanParam bladerParameters: BladerParameters
    ): Response {
        val (afdelingen, totaalAantalAfdelingen) = afdelingRepository.listAll(
            bladerParameters.page,
            bladerParameters.pageSize
        )
        return ok(
            AfdelingOverzichtResults(
                afdelingen.map { it.toAfdelingOverzicht() },
                totaalAantalAfdelingen,
                bladerParameters.page,
                bladerParameters.pageSize,
            )
        ).build()
    }

    @GET
    @Path("{naam}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "afdeling_read", summary = "Een specifieke medewerker opvragen")
    @APIResponse(
        responseCode = "200",
        description = "OK",
        content = [Content(schema = Schema(implementation = Medewerker::class))]
    )
    fun afdelingRead(@PathParam("naam") naam: String): Response {
        return ok(
            afdelingRepository.findByNaam(naam)
                ?.let { it.toAfdeling() }
                ?: throw WebApplicationException("Afdeling not found", 404)
        ).build()
    }
}
