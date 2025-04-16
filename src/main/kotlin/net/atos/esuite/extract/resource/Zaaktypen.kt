package net.atos.esuite.extract.resource

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.converter.toZaaktype
import net.atos.esuite.extract.model.Zaaktype
import net.atos.esuite.extract.repository.ZaaktypeRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("/zaaktypen")
class Zaaktypen(
    private val zaaktypeRepository: ZaaktypeRepository
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "zaaktype_list", summary = "Lijst van zaaktypen opvragen")
    @APIResponse(responseCode = "200", description = "OK")
    fun zaakList(): List<Zaaktype> {
        return zaaktypeRepository.findAll().list().map { it.toZaaktype() }
    }
}
