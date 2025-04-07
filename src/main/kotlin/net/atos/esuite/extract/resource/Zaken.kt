package net.atos.esuite.extract.resource

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.converter.ZaakConverter
import net.atos.esuite.extract.converter.ZaakOverzichtConverter
import net.atos.esuite.extract.model.BladerParameters
import net.atos.esuite.extract.model.Zaak
import net.atos.esuite.extract.model.ZaakResults
import net.atos.esuite.extract.repository.ZaakRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import java.util.Collections
import java.util.stream.Collectors

@Path("/zaken")
class Zaken(
    private val zaakRepository: ZaakRepository,
    private val zaakConverter: ZaakConverter,
    private val zaakOverzichtConverter: ZaakOverzichtConverter,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "zaak_list",
        summary = "Lijst van zaak overzichten opvragen"
    )
    @APIResponse(
        responseCode = "200",
        description = "OK",
        content = [Content(schema = Schema(implementation = ZaakResults::class))]
    )
    fun zaakList(
        @QueryParam("zaaktype")
        @Schema(description = "Zaaktype naam", maxLength = 255, required = true)
        zaaktype: String,

        @BeanParam bladerParameters: BladerParameters
    ): Response {
        val zaken = zaakRepository.listByZaaktypeFunctioneelId(zaaktype, bladerParameters.page, bladerParameters.pageSize)
            .map(zaakOverzichtConverter::convert)
        return ok(ZaakResults(10, null, null, zaken)).build()
    }

    @GET
    @Path("{functionele_Identificatie}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "zaak_read",
        summary = "Een specifieke zaak opvragen"
    )
    @APIResponse(
        responseCode = "200",
        description = "OK",
        content = [Content(schema = Schema(implementation = Zaak::class))]
    )
    fun zaakRead(@PathParam("functionele_Identificatie") functioneleIdentificatie: String): Response {
        return ok(
            zaakRepository.findByFunctioneleIdentificatie(functioneleIdentificatie)
                ?.let { zaakConverter.convert(it) }
                ?: throw WebApplicationException("Zaak not found", 404))
            .build()
    }
}
