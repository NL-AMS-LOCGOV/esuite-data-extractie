package net.atos.esuite.extract.api.resource

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import net.atos.esuite.extract.api.convert.contact.ContactConverter
import net.atos.esuite.extract.api.convert.shared.toPage
import net.atos.esuite.extract.api.model.contact.Contact
import net.atos.esuite.extract.api.model.contact.ContactOverzichtResults
import net.atos.esuite.extract.api.model.shared.BladerParameters
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.db.repository.contact.ContactRepository
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("contacten")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
class Contacten(
    private val contactRepository: ContactRepository,
    private val contactConverter: ContactConverter,
) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "contact_list", summary = "Lijst van contact overzichten opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = ContactOverzichtResults::class))]
    )
    fun contactList(
        @BeanParam @Valid bladerParameters: BladerParameters
    ) =
        with(contactRepository.findAll().page(bladerParameters.toPage())) {
            ContactOverzichtResults(
                list().map { contactConverter.toContactOverzicht(it) }, count(), hasPreviousPage(), hasNextPage(),
            )
        }

    @GET
    @Path("{functionele_Identificatie}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(operationId = "contact_read", summary = "Een specifiek contact opvragen")
    @APIResponse(
        responseCode = "200", description = "OK",
        content = [Content(schema = Schema(implementation = Contact::class))]
    )
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun contactRead(@PathParam("functionele_Identificatie") functioneleIdentificatie: String) =
        contactRepository.findByFunctioneleIdentificatie(functioneleIdentificatie)
            ?.let { contactConverter.toContact(it) }
            ?: throw NotFoundException("Contact with functionele identificatie '$functioneleIdentificatie' not found")
}
