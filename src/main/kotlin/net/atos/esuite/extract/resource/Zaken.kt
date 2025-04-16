package net.atos.esuite.extract.resource

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.converter.ZaakConverter
import net.atos.esuite.extract.model.BladerParameters
import net.atos.esuite.extract.model.Zaak
import net.atos.esuite.extract.model.ZaakResults
import net.atos.esuite.extract.repository.ZaakRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("/zaken")
class Zaken(
    private val zaakRepository: ZaakRepository,
    private val zaakConverter: ZaakConverter,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "zaak_list", summary = "Lijst van zaken opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = ZaakResults::class))]
    )
    fun zaakList(
        @QueryParam("zaaktype")
        @Schema(description = "Zaaktype naam", maxLength = 255, required = true) zaaktype: String,

        @BeanParam bladerParameters: BladerParameters
    ): Response {
        val (zaken, totaalAantalZaken) = zaakRepository.listByZaaktypeFunctioneelId(
            zaaktype, bladerParameters.page, bladerParameters.pageSize
        )
        return ok(
            ZaakResults(
                count = totaalAantalZaken,
                previousPage = if (bladerParameters.page > 0) bladerParameters.page - 1 else null,
                nextPage = if (totaalAantalZaken > (bladerParameters.page + 1) * bladerParameters.pageSize) bladerParameters.page + 1 else null,
                results = zaken.map { zaakConverter.toZaak(it) },
            )
        ).build()
    }

    @GET
    @Path("{functionele_Identificatie}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "zaak_read", summary = "Een specifieke zaak opvragen")
    @APIResponse(
        responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Zaak::class))]
    )
    fun zaakRead(@PathParam("functionele_Identificatie") functioneleIdentificatie: String): Response {
        return ok(
            zaakRepository.findByFunctioneleIdentificatie(functioneleIdentificatie)
                ?.let { zaakConverter.toZaak(it) }
                ?: throw WebApplicationException("Zaak not found", 404)).build()
    }
}
