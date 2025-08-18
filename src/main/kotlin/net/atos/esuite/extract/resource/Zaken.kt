package net.atos.esuite.extract.resource

import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.converter.zaak.ZaakConverter
import net.atos.esuite.extract.model.shared.BladerParameters
import net.atos.esuite.extract.model.shared.Fout
import net.atos.esuite.extract.model.shared.ValidatieFouten
import net.atos.esuite.extract.model.zaak.Zaak
import net.atos.esuite.extract.model.zaak.ZaakOverzichtResults
import net.atos.esuite.extract.repository.zaak.ZaakRepository
import net.atos.esuite.extract.validation.FALSE
import net.atos.esuite.extract.validation.ValidBoolean
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
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
    @Operation(operationId = "zaak_list", summary = "Lijst van zaak overzichten opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = ZaakOverzichtResults::class))]
    )
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
    ): Response {
        val (zaken, totaalAantalZaken) = zaakRepository.listByZaaktypeFunctioneelId(
            zaaktype, inclusiefOpen.toBoolean(), bladerParameters.page, bladerParameters.pageSize
        )
        return ok(
            ZaakOverzichtResults(
                zaken.map { zaakConverter.toZaakOverzicht(it) },
                totaalAantalZaken,
                bladerParameters.page,
                bladerParameters.pageSize,
            )
        ).build()
    }

    @GET
    @Path("{functionele_Identificatie}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "zaak_read", summary = "Een specifieke zaak opvragen op basis van de functiele identificatie")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = Zaak::class))]
    )
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun zaakRead(@PathParam("functionele_Identificatie") functioneleIdentificatie: String): Response {
        return ok(
            zaakRepository.findByFunctioneleIdentificatie(functioneleIdentificatie)
                ?.let { zaakConverter.toZaak(it) }
                ?: throw NotFoundException("Zaak with functionele identificatie '$functioneleIdentificatie' Not Found")
        ).build()
    }
}
