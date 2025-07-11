package net.atos.esuite.extract.resource

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.converter.zaak.toZaaktype
import net.atos.esuite.extract.model.shared.Fout
import net.atos.esuite.extract.model.zaak.Zaaktype
import net.atos.esuite.extract.repository.zaak.ZaaktypeRepository
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
    fun zaaktypeList(): List<Zaaktype> {
        return zaaktypeRepository.findAll().list().map { it.toZaaktype() }
    }
}
