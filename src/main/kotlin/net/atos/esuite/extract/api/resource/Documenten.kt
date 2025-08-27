package net.atos.esuite.extract.api.resource

import io.quarkus.narayana.jta.BeginOptions
import io.quarkus.narayana.jta.QuarkusTransaction
import jakarta.ws.rs.*
import jakarta.ws.rs.core.HttpHeaders
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import jakarta.ws.rs.core.StreamingOutput
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.db.repository.document.DocumentInhoudRepository
import org.apache.commons.io.IOUtils
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import java.io.OutputStream
import java.sql.Blob
import java.util.zip.ZipInputStream


@Path("documenten")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
class Documenten(
    private val documentInhoudRepository: DocumentInhoudRepository
) {
    @GET
    @Path("inhoud/{documentInhoudID}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Operation(operationId = "document_inhoud_read", summary = "Inhoud van een document ophalen")
    @APIResponse(
        responseCode = "200", description = "OK", content = [
            Content(
                mediaType = MediaType.APPLICATION_OCTET_STREAM,
                schema = Schema(
                    implementation = String::class,
                    format = "binary",
                    description = "Inhoud van het document"
                )
            )]
    )
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    // ToDo: Dit werkt nog niet correct!
    fun documentInhoudRead(@PathParam("documentInhoudID") documentInhoudID: Long): Response {
        QuarkusTransaction.begin(BeginOptions().timeout(300)) // 5 minuten
        val documentInhoudEntity = documentInhoudRepository.findById(documentInhoudID)
            ?: throw NotFoundException("Document inhoud with ID '$documentInhoudID' not found")
        val inhoud = documentInhoudEntity.inhoud
            ?: throw NotFoundException("Document inhoud with ID '$documentInhoudID' is empty")
        return ok(
            StreamingOutput { output: OutputStream ->
                try {
                    copyBlob(inhoud, documentInhoudEntity.compressed, output)
                    QuarkusTransaction.commit()
                } finally {
                    QuarkusTransaction.rollback()
                }
            })
            .type(MediaType.APPLICATION_OCTET_STREAM)
            .header(HttpHeaders.CONTENT_LENGTH, documentInhoudEntity.documentgrootte)
            .build()
    }

    private fun copyBlob(inhoud: Blob, compressed: Boolean, outputStream: OutputStream) {
        inhoud.getBinaryStream().use { inputStream ->
            if (compressed) {
                ZipInputStream(inputStream).use { zipInputStream ->
                    zipInputStream.getNextEntry()
                    IOUtils.copy(zipInputStream, outputStream)
                    zipInputStream.closeEntry()
                }
            } else {
                IOUtils.copy(inputStream, outputStream)
            }
        }
    }
}
