package net.atos.esuite.extract.resource

import jakarta.ws.rs.BeanParam
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.WebApplicationException
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.converter.dsr.ReferentietabelConverter
import net.atos.esuite.extract.converter.dsr.toReferentietabelRecord
import net.atos.esuite.extract.model.dsr.tabel.Referentietabel
import net.atos.esuite.extract.model.dsr.tabel.ReferentietabelRecordResults
import net.atos.esuite.extract.model.dsr.tabel.ReferentietabelResults
import net.atos.esuite.extract.model.shared.BladerParameters
import net.atos.esuite.extract.repository.dsr.ReferentietabelDefinitieRepository
import net.atos.esuite.extract.repository.dsr.ReferentietabelRecordRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("referentietabellen")
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
        @BeanParam bladerParameters: BladerParameters
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
    @Path("{referentietabel_naam}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "referentietabel_read", summary = "Een specifieke referentietabel opvragen")
    @APIResponse(
        responseCode = "200",
        description = "OK",
        content = [Content(schema = Schema(implementation = Referentietabel::class))]
    )
    @APIResponse(responseCode = "404", description = "Referentietabel not found")
    fun referentietabelRead(@PathParam("referentietabel_naam") referentietabelNaam: String): Response {
        return ok(
            referentietabelDefinitieRepository.findByNaam(referentietabelNaam)
                ?.let { referentietabelConverter.toReferentietabel(it) }
                ?: throw WebApplicationException("Referentietabel not found", Response.Status.NOT_FOUND))
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
        @BeanParam bladerParameters: BladerParameters
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
