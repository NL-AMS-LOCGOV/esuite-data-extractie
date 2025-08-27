package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.ws.rs.BeanParam
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.api.convert.shared.toPage
import net.atos.esuite.extract.api.convert.zaak.toZaaktype
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.model.shared.Results
import net.atos.esuite.extract.db.repository.zaak.ZaaktypeRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("zaaktypen")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
class Zaaktypen(
    private val zaaktypeRepository: ZaaktypeRepository
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "zaaktype_list", summary = "Lijst van zaaktypen opvragen")
    @APIResponse(responseCode = "200", description = "OK")
    fun zaaktypeList(@BeanParam @Valid bladerParameters: BladerParameters) =
        with(zaaktypeRepository.findAll().page(bladerParameters.toPage())) {
            Results(list().map { it.toZaaktype() }, count(), hasPreviousPage(), hasNextPage())
        }
}
