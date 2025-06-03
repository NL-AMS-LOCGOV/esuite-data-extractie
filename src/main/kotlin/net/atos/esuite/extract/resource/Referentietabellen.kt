package net.atos.esuite.extract.resource

import jakarta.ws.rs.BeanParam
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.converter.dsr.ReferentietabelConverter
import net.atos.esuite.extract.model.dsr.ReferentietabelOverzichtResults
import net.atos.esuite.extract.model.shared.BladerParameters
import net.atos.esuite.extract.model.zaak.ZaakOverzichtResults
import net.atos.esuite.extract.repository.dsr.ReferentietabelDefinitieRepository
import net.atos.esuite.extract.repository.dsr.ReferentietabelRecordRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("referentietabellen")
class Referentietabellen(
    private val referentietabelDefinitieRepository: ReferentietabelDefinitieRepository,
    private val referentietabelConverter: ReferentietabelConverter,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "referentietabel_list", summary = "Lijst van referentietabel overzichten opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = ReferentietabelOverzichtResults::class))]
    )
    fun referentietabelList(
        @BeanParam bladerParameters: BladerParameters
    ): Response {
        val (referentietabellen, totaalAantalReferentietabellen) = referentietabelDefinitieRepository.list(
            bladerParameters.page, bladerParameters.pageSize
        )
        return ok(
            ReferentietabelOverzichtResults(
                referentietabellen.map { referentietabelConverter.toReferentietabelOverzicht(it) },
                totaalAantalReferentietabellen,
                bladerParameters.page,
                bladerParameters.pageSize,
            )
        ).build()
    }
}
