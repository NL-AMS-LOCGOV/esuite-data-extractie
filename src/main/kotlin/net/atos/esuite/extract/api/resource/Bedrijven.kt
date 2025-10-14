package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.api.convert.basisgegevens.toBedrijf
import net.atos.esuite.extract.api.convert.shared.toPage
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.model.shared.Results
import net.atos.esuite.extract.api.model.shared.ValidatieFouten
import net.atos.esuite.extract.api.validation.ValidKVKNummer
import net.atos.esuite.extract.api.validation.ValidNonNegativeInteger
import net.atos.esuite.extract.api.validation.ValidVestigingsnummer
import net.atos.esuite.extract.db.basisgegevens.repository.BedrijfRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("bedrijven")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
class Bedrijven(
    private val bedrijfRepository: BedrijfRepository,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "bedrijf_list",
        summary = "Bedrijven opvragen op basis van KvK nummer en of vestigingsnummer"
    )
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "400", description = "Bad Request",
        content = [Content(schema = Schema(implementation = ValidatieFouten::class))]
    )
    fun bedrijfList(
        @Schema(description = "KvK nummer", minLength = 8, maxLength = 8)
        @QueryParam("kvk_nummer")
        @ValidKVKNummer
        kvkNummer: String?,

        @Schema(description = "vestigingsnummer", minLength = 12, maxLength = 12)
        @QueryParam("vestigingsnummer")
        @ValidVestigingsnummer
        vestigingsnummer: String?,

        @BeanParam @Valid bladerParameters: BladerParameters
    ) =
        with(
            when {
                !kvkNummer.isNullOrBlank() && !vestigingsnummer.isNullOrBlank() ->
                    bedrijfRepository.listByKvkNummerAndVestigingsnummer(kvkNummer, vestigingsnummer)

                !kvkNummer.isNullOrBlank() ->
                    bedrijfRepository.listByKvkNummer(kvkNummer)

                !vestigingsnummer.isNullOrBlank() ->
                    bedrijfRepository.listByVestigingsnummer(vestigingsnummer)

                else -> throw BadRequestException("Either KvK nummer or vestigingsnummer must be provided")
            }.page(bladerParameters.toPage())
        ) {
            Results(list().map { it.toBedrijf() }, count(), hasPreviousPage(), hasNextPage())
        }

    @GET
    @Path("{identifier}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "bedrijf_read", summary = "Een specifiek bedrijf opvragen op basis van interne identifier")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun bedrijfRead(
        @PathParam("identifier")
        @Schema(description = "Interne identifier van bedrijf", implementation = Long::class)
        @ValidNonNegativeInteger
        identifier: String
    ) =
        bedrijfRepository.findById(identifier.toLong())
            ?.toBedrijf()
            ?: throw NotFoundException("Bedrijf with identifier '$identifier' not found")
}
