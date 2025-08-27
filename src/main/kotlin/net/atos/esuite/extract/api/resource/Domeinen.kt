package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.api.convert.dsr.DomeinConverter
import net.atos.esuite.extract.api.convert.dsr.toDomeinObject
import net.atos.esuite.extract.api.convert.shared.toPage
import net.atos.esuite.extract.api.model.dsr.domein.Domein
import net.atos.esuite.extract.api.model.dsr.domein.DomeinObjectResults
import net.atos.esuite.extract.api.model.dsr.domein.DomeinResults
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
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
    ) =
        with(domeinDefinitieRepository.findAll().page(bladerParameters.toPage())) {
            DomeinResults(
                list().map { domeinConverter.toDomein(it) },
                count(),
                hasPreviousPage(),
                hasNextPage(),
            )
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
    fun domeinRead(@PathParam("naam") naam: String) =
        domeinDefinitieRepository.findByNaam(naam)
            ?.let { domeinConverter.toDomein(it) }
            ?: throw NotFoundException("Domein with naam '$naam' not found")

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
    ) =
        with(domeinObjectRepository.listByDomeinNaam(domeinNaam).page(bladerParameters.toPage())) {
            DomeinObjectResults(list().map { it.toDomeinObject() }, count(), hasPreviousPage(), hasNextPage())
        }
}
