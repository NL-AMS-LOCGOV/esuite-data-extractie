package net.atos.esuite.extract.resource

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.converter.basisgegevens.toBedrijf
import net.atos.esuite.extract.entity.basisgegevens.BedrijfEntity
import net.atos.esuite.extract.model.basisgegevens.Bedrijf
import net.atos.esuite.extract.model.shared.Fout
import net.atos.esuite.extract.repository.basisgegevens.BedrijfRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("bedrijven")
class Bedrijven(
    private val bedrijfRepository: BedrijfRepository,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "bedrijf_list_kvk_nummer_vestigingsnummer",
        summary = "Bedrijven opvragen op basis van een KvK nummer en of vestigingsnummer"
    )
    @APIResponse(
        responseCode = "200",
        description = "OK")
    @APIResponse(
        responseCode = "400",
        description = "Either KvK nummer or vestigingsnummer must be provided",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun bedrijfListOpKvkNummer(
        @Schema(description = "KvK nummer", minLength = 8, maxLength = 8)
        @QueryParam("kvk_nummer") kvkNummer: String?,

        @Schema(description = "vestigingsnummer", minLength = 12, maxLength = 12)
        @QueryParam("vestigingsnummer") vestigingsnummer: String?
    ): List<Bedrijf> {
        if (kvkNummer.isNullOrBlank() && vestigingsnummer.isNullOrBlank()) {
            throw IllegalArgumentException("Either KvK nummer or vestigingsnummer must be provided")
        }
        val bedrijven: List<BedrijfEntity> =
            if (kvkNummer.isNullOrBlank()) bedrijfRepository.listByVestigingsnummer(vestigingsnummer!!)
            else if (vestigingsnummer.isNullOrBlank()) bedrijfRepository.listByKvkNummer(kvkNummer)
            else bedrijfRepository.listByKvkNummerAndVestigingsnummer(kvkNummer, vestigingsnummer)
        return bedrijven.map { it.toBedrijf() }
    }
}
