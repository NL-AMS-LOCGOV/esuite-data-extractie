package net.atos.esuite.extract.resource

import jakarta.validation.Valid
import jakarta.ws.rs.BeanParam
import jakarta.ws.rs.GET
import jakarta.ws.rs.NotFoundException
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import net.atos.esuite.extract.converter.contact.ContactConverter
import net.atos.esuite.extract.model.shared.BladerParameters
import net.atos.esuite.extract.model.contact.Contact
import net.atos.esuite.extract.model.contact.ContactOverzichtResults
import net.atos.esuite.extract.model.shared.Fout
import net.atos.esuite.extract.repository.contact.ContactRepository
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
    ): Response {
        val (contacten, totaalAantalContacten) =
            contactRepository.listAll(bladerParameters.page, bladerParameters.pageSize)
        return ok(
            ContactOverzichtResults(
                contacten.map { contactConverter.toContactOverzicht(it) },
                totaalAantalContacten,
                bladerParameters.page,
                bladerParameters.pageSize,
            )
        ).build()
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
    fun contactRead(@PathParam("functionele_Identificatie") functioneleIdentificatie: String): Response {
        return ok(
            contactRepository.findByFunctioneleIdentificatie(functioneleIdentificatie)
                ?.let { contactConverter.toContact(it) }
                ?: throw NotFoundException("Contact with functionele identificatie '$functioneleIdentificatie' Not Found"))
            .build()
    }
}
