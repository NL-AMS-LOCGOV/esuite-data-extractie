package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.api.convert.shared.toPage
import net.atos.esuite.extract.api.convert.zaak.ZaakConverter
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.model.shared.Results
import net.atos.esuite.extract.api.model.shared.ValidatieFouten
import net.atos.esuite.extract.api.model.zaak.ZaakOverzicht
import net.atos.esuite.extract.api.model.zaak.ZaakPatch
import net.atos.esuite.extract.api.validation.FALSE
import net.atos.esuite.extract.api.validation.ValidBoolean
import net.atos.esuite.extract.db.repository.zaak.ZaakRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("zaken")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
class Zaken(
    private val zaakRepository: ZaakRepository,
    private val zaakConverter: ZaakConverter,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "zaak_list", summary = "Lijst van zaak overzichten van afgeronde zaken opvragen. " +
                "Indien parameter 'inclusiefOpen=true' wordt meegegeven dan bevat de lijst ook openstaande zaken."
    )
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "400", description = "Bad Request",
        content = [Content(schema = Schema(implementation = ValidatieFouten::class))]
    )
    fun zaakList(
        @QueryParam("zaaktype")
        @Schema(description = "Zaaktype naam", maxLength = 255, required = true)
        @NotNull(message = "zaaktype is verplicht")
        zaaktype: String,

        @QueryParam("inclusiefOpen")
        @Schema(description = "Inclusief open zaken", defaultValue = "false", implementation = Boolean::class)
        @ValidBoolean
        inclusiefOpen: String? = FALSE,

        @BeanParam @Valid bladerParameters: BladerParameters
    ) =
        with(
            zaakRepository.listByZaaktypeFunctioneelId(zaaktype, inclusiefOpen.toBoolean())
                .page(bladerParameters.toPage())
        ) {
            Results(list().map { zaakConverter.toZaakOverzicht(it) }, count(), hasPreviousPage(), hasNextPage())
        }

    @GET
    @Path("{functionele_Identificatie}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "zaak_read", summary = "Een specifieke zaak opvragen op basis van de functiele identificatie")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun zaakRead(@PathParam("functionele_Identificatie") functioneleIdentificatie: String) =
        zaakRepository.findByFunctioneleIdentificatie(functioneleIdentificatie)
            ?.let { zaakConverter.toZaak(it) }
            ?: throw NotFoundException("Zaak with functionele identificatie '$functioneleIdentificatie' not found")

    @PATCH
    @Path("{functionele_Identificatie}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "zaak_patch", summary = "Voor een specifieke zaak aangeven of deze is gemigreerd")
    @APIResponse(responseCode = "204", description = "No Content")
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun zaakPatch(
        @PathParam("functionele_Identificatie") functioneleIdentificatie: String,
        @RequestBody(required = true) @Valid @NotNull zaakPatch: ZaakPatch
    ): ZaakOverzicht {
        println("zaakPatch called with functioneleIdentificatie '$functioneleIdentificatie' and migrated: ${zaakPatch.gemigreerd}")
        return zaakRepository.findByFunctioneleIdentificatie(functioneleIdentificatie)
            ?.let { zaakConverter.toZaakOverzicht(it) }
            ?: throw NotFoundException("Zaak with functionele identificatie '$functioneleIdentificatie' not found")
    }
}
