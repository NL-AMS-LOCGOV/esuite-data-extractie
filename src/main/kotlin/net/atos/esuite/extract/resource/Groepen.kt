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
import net.atos.esuite.extract.converter.identity.toGroep
import net.atos.esuite.extract.converter.identity.toGroepOverzicht
import net.atos.esuite.extract.model.shared.BladerParameters
import net.atos.esuite.extract.model.identity.Groep
import net.atos.esuite.extract.model.identity.GroepOverzichtResults
import net.atos.esuite.extract.model.shared.Fout
import net.atos.esuite.extract.repository.identity.GroepRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

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
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = GroepOverzichtResults::class))]
    )
    fun groepList(
        @BeanParam @Valid bladerParameters: BladerParameters
    ): Response {
        val (groepen, totaalAantalGroepen) = groepRepository.listAll(
            bladerParameters.page,
            bladerParameters.pageSize
        )
        return ok(
            GroepOverzichtResults(
                results = groepen.map { it.toGroepOverzicht() },
                totaalAantalGroepen,
                bladerParameters.page,
                bladerParameters.pageSize,
            )
        ).build()
    }

    @GET
    @Path("{naam}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "groep_read", summary = "Een specifieke groep opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = Groep::class))]
    )
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun groepRead(@PathParam("naam") naam: String): Response {
        return ok(
            groepRepository.findByNaam(naam)
                ?.toGroep()
                ?: throw NotFoundException("Groep with naam '$naam' Not Found with name '$naam'")
        ).build()
    }
}
