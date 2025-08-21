package net.atos.esuite.extract.api.resource

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.api.convert.basisgegevens.toBedrijf
import net.atos.esuite.extract.api.model.basisgegevens.Bedrijf
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.model.shared.ValidatieFouten
import net.atos.esuite.extract.api.validation.ValidKVKNummer
import net.atos.esuite.extract.api.validation.ValidVestigingsnummer
import net.atos.esuite.extract.db.entity.basisgegevens.BedrijfEntity
import net.atos.esuite.extract.db.repository.basisgegevens.BedrijfRepository
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
        vestigingsnummer: String?
    ): List<Bedrijf> {
        val bedrijven: List<BedrijfEntity> =
            when {
                !kvkNummer.isNullOrBlank() && !vestigingsnummer.isNullOrBlank() ->
                    bedrijfRepository.listByKvkNummerAndVestigingsnummer(kvkNummer, vestigingsnummer)
                !kvkNummer.isNullOrBlank() ->
                    bedrijfRepository.listByKvkNummer(kvkNummer)
                !vestigingsnummer.isNullOrBlank() ->
                    bedrijfRepository.listByVestigingsnummer(vestigingsnummer)
                else -> throw BadRequestException("Either KvK nummer or vestigingsnummer must be provided")
            }
        return bedrijven.map { it.toBedrijf() }
    }

    @GET
    @Path("{identifier}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "bedrijf_read", summary = "Een specifiek bedrijf opvragen op basis van interne identifier")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = Bedrijf::class))]
    )
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun bedrijfRead(@PathParam("identifier") identifier: Long): Response {
        return ok(
            bedrijfRepository.findById(identifier)
                ?.toBedrijf()
                ?: throw NotFoundException("Bedrijf with identifier '$identifier' Not Found")
        ).build()
    }
}
