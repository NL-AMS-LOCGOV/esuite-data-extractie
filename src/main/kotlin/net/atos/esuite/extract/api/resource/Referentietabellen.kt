package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.api.convert.dsr.ReferentietabelConverter
import net.atos.esuite.extract.api.convert.dsr.toReferentietabelRecord
import net.atos.esuite.extract.api.model.dsr.tabel.Referentietabel
import net.atos.esuite.extract.api.model.dsr.tabel.ReferentietabelRecordResults
import net.atos.esuite.extract.api.model.dsr.tabel.ReferentietabelResults
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
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
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = ReferentietabelResults::class))]
    )
    fun referentietabelList(
        @BeanParam @Valid bladerParameters: BladerParameters
    ): Response {
        val (referentietabellen, totaalAantalReferentietabellen) = referentietabelDefinitieRepository.listAll(
            bladerParameters.page, bladerParameters.pageSize
        )
        return ok(
            ReferentietabelResults(
                referentietabellen.map { referentietabelConverter.toReferentietabel(it) },
                totaalAantalReferentietabellen,
                bladerParameters.page,
                bladerParameters.pageSize,
            )
        ).build()
    }

    @GET
    @Path("{naam}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "referentietabel_read", summary = "Een specifieke referentietabel opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = Referentietabel::class))]
    )
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun referentietabelRead(@PathParam("naam") naam: String): Response {
        return ok(
            referentietabelDefinitieRepository.findByNaam(naam)
                ?.let { referentietabelConverter.toReferentietabel(it) }
                ?: throw NotFoundException("Referentietabel with naam '$naam' Not Found"))
            .build()
    }

    @GET
    @Path("{referentietabel_naam}/records")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "referentietabel_record_list", summary = "Records van een referentietabel opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = ReferentietabelRecordResults::class))]
    )
    fun referentietabelRecordList(
        @PathParam("referentietabel_naam") referentietabelNaam: String,
        @BeanParam @Valid bladerParameters: BladerParameters
    ): Response {
        val (records, totaalAantalRecords) = referentietabelRecordRepository.listByReferentietabelNaam(referentietabelNaam,
            bladerParameters.page, bladerParameters.pageSize
        )
        return ok(
            ReferentietabelRecordResults(
                records.map { it.toReferentietabelRecord() },
                totaalAantalRecords,
                bladerParameters.page,
                bladerParameters.pageSize,
            )
        ).build()
    }
}
