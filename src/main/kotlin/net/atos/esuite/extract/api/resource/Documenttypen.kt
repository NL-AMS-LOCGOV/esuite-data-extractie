package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.ws.rs.BeanParam
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.api.converter.toDocumenttype
import net.atos.esuite.extract.api.converter.toPage
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.model.shared.Results
import net.atos.esuite.extract.api.model.shared.ValidatieFouten
import net.atos.esuite.extract.db.zakenmagazijn.repository.DocumentTypeRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("documenttypen")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
class Documenttypen(private val documentTypeRepository: DocumentTypeRepository) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "documenttype_list", summary = "Lijst van documenttypen opvragen")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(
        responseCode = "400", description = "Bad Request",
        content = [Content(schema = Schema(implementation = ValidatieFouten::class))]
    )
    fun documenttypeList(@BeanParam @Valid bladerParameters: BladerParameters) =
        with(documentTypeRepository.findAll().page(bladerParameters.toPage())) {
            Results(list().map { it.toDocumenttype() }, count(), hasPreviousPage(), hasNextPage())
        }
}
