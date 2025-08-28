package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.api.convert.dsr.ReferentietabelConverter
import net.atos.esuite.extract.api.convert.dsr.toReferentietabelRecord
import net.atos.esuite.extract.api.convert.shared.toPage
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.model.shared.Results
import net.atos.esuite.extract.api.model.shared.ValidatieFouten
import net.atos.esuite.extract.db.repository.dsr.ReferentietabelDefinitieRepository
import net.atos.esuite.extract.db.repository.dsr.ReferentietabelRecordRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("referentietabellen")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
class Referentietabellen(
    private val referentietabelDefinitieRepository: ReferentietabelDefinitieRepository,
    private val referentietabelRecordRepository: ReferentietabelRecordRepository,
    private val referentietabelConverter: ReferentietabelConverter,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "referentietabel_list", summary = "Lijst van referentietabellen opvragen")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "400", description = "Bad Request",
        content = [Content(schema = Schema(implementation = ValidatieFouten::class))]
    )
    fun referentietabelList(@BeanParam @Valid bladerParameters: BladerParameters) =
        with(referentietabelDefinitieRepository.findAll().page(bladerParameters.toPage())) {
            Results(list().map { referentietabelConverter.toReferentietabel(it) }, count(), hasPreviousPage(), hasNextPage())
        }

    @GET
    @Path("{naam}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "referentietabel_read", summary = "Een specifieke referentietabel opvragen")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun referentietabelRead(@PathParam("naam") naam: String) =
        referentietabelDefinitieRepository.findByNaam(naam)
            ?.let { referentietabelConverter.toReferentietabel(it) }
            ?: throw NotFoundException("Referentietabel with naam '$naam' not found")

    @GET
    @Path("{referentietabel_naam}/records")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "referentietabel_record_list", summary = "Records van een referentietabel opvragen")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "400", description = "Bad Request",
        content = [Content(schema = Schema(implementation = ValidatieFouten::class))]
    )
    fun referentietabelRecordList(
        @PathParam("referentietabel_naam") referentietabelNaam: String,
        @BeanParam @Valid bladerParameters: BladerParameters
    ) =
        with(referentietabelRecordRepository.listByReferentietabelNaam(referentietabelNaam).page(bladerParameters.toPage())) {
            Results(list().map { it.toReferentietabelRecord() }, count(), hasPreviousPage(), hasNextPage())
        }
}
