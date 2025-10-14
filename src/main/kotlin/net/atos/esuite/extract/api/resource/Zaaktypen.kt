package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.api.convert.shared.toPage
import net.atos.esuite.extract.api.convert.zaak.toZaaktype
import net.atos.esuite.extract.api.convert.zaak.toZaaktypeOverzicht
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.model.shared.Results
import net.atos.esuite.extract.api.model.shared.ValidatieFouten
import net.atos.esuite.extract.db.zakenmagazijn.repository.ZaaktypeRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import org.hibernate.validator.constraints.Length

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
    @APIResponse(
        responseCode = "400", description = "Bad Request",
        content = [Content(schema = Schema(implementation = ValidatieFouten::class))]
    )
    fun zaaktypeList(@BeanParam @Valid bladerParameters: BladerParameters) =
        with(zaaktypeRepository.findAll().page(bladerParameters.toPage())) {
            Results(list().map { it.toZaaktypeOverzicht() }, count(), hasPreviousPage(), hasNextPage())
        }

    @GET
    @Path("{functioneleIdentificatie}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "zaaktype_read", summary = "Een specifiek zaaktype opvragen op basis van functionele identificatie")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun zaaktypeRead(
        @PathParam("functioneleIdentificatie")
        @Schema(description = "Functionele identificatie", maxLength = 128)
        @Length(max = 128, message = "Functionele identificatie mag niet langer zijn dan 128 tekens")
        functioneleIdentificatie: String
    ) =
        zaaktypeRepository.findByFunctioneleIdentificatie(functioneleIdentificatie)
            ?.toZaaktype()
            ?: throw NotFoundException("Zaaktype with functionele identificatie '$functioneleIdentificatie' not found")
}
