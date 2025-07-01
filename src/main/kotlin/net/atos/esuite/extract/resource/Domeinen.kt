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
import net.atos.esuite.extract.converter.dsr.DomeinConverter
import net.atos.esuite.extract.converter.dsr.toDomeinObject
import net.atos.esuite.extract.model.dsr.domein.Domein
import net.atos.esuite.extract.model.dsr.domein.DomeinObjectResults
import net.atos.esuite.extract.model.dsr.domein.DomeinResults
import net.atos.esuite.extract.model.shared.BladerParameters
import net.atos.esuite.extract.repository.dsr.DomeinDefinitieRepository
import net.atos.esuite.extract.repository.dsr.DomeinObjectRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("domeinen")
class Domeinen(
    private val domeinDefinitieRepository: DomeinDefinitieRepository,
    private val domeinConverter: DomeinConverter,
    private val domeinObjectRepository: DomeinObjectRepository,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "domein_list", summary = "Lijst van domeinen opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = DomeinResults::class))]
    )
    fun domeinList(
        @BeanParam bladerParameters: BladerParameters
    ): Response {
        val (domeinen, totaalAantalDomeinen) = domeinDefinitieRepository.listAll(
            bladerParameters.page, bladerParameters.pageSize
        )
        return ok(
            DomeinResults(
                domeinen.map { domeinConverter.toDomein(it) },
                totaalAantalDomeinen,
                bladerParameters.page,
                bladerParameters.pageSize,
            )
        ).build()
    }

    @GET
    @Path("{domein_naam}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "domein_read", summary = "Een specifiek domein opvragen")
    @APIResponse(
        responseCode = "200",
        description = "OK",
        content = [Content(schema = Schema(implementation = Domein::class))]
    )
    @APIResponse(responseCode = "404", description = "Domein not found")
    fun domeinRead(@PathParam("domein_naam") domeinNaam: String): Response {
        return ok(
            domeinDefinitieRepository.findByNaam(domeinNaam)
                ?.let { domeinConverter.toDomein(it) }
                ?: throw WebApplicationException("Domein not found", 404))
            .build()
    }

    @GET
    @Path("{domein_naam}/objecten")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "domein_object_list", summary = "Objecten van een domein opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = DomeinObjectResults::class))]
    )
    fun domeinObjectList(
        @PathParam("domein_naam") domeinNaam: String,
        @BeanParam bladerParameters: BladerParameters
    ): Response {
        val (objecten, totaalAantalObjecten) = domeinObjectRepository.listByDomeinNaam(domeinNaam,
            bladerParameters.page, bladerParameters.pageSize
        )
        return ok(
            DomeinObjectResults(
                objecten.map { it.toDomeinObject() },
                totaalAantalObjecten,
                bladerParameters.page,
                bladerParameters.pageSize,
            )
        ).build()
    }
}
