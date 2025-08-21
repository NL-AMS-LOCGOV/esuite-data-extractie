package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.api.model.dsr.domein.Domein
import net.atos.esuite.extract.api.model.dsr.domein.DomeinObjectResults
import net.atos.esuite.extract.api.model.dsr.domein.DomeinResults
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.convert.dsr.DomeinConverter
import net.atos.esuite.extract.convert.dsr.toDomeinObject
import net.atos.esuite.extract.db.repository.dsr.DomeinDefinitieRepository
import net.atos.esuite.extract.db.repository.dsr.DomeinObjectRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("domeinen")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
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
        @BeanParam @Valid bladerParameters: BladerParameters
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
    @Path("{naam}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "domein_read", summary = "Een specifiek domein opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = Domein::class))]
    )
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun domeinRead(@PathParam("naam") naam: String): Response {
        return ok(
            domeinDefinitieRepository.findByNaam(naam)
                ?.let { domeinConverter.toDomein(it) }
                ?: throw NotFoundException("Domein with naam '$naam' Not Found"))
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
        @BeanParam @Valid bladerParameters: BladerParameters
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
