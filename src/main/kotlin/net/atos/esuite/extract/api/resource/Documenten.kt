package net.atos.esuite.extract.api.resource

import jakarta.transaction.Transactional
import jakarta.ws.rs.*
import jakarta.ws.rs.core.HttpHeaders
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import jakarta.ws.rs.core.StreamingOutput
import net.atos.esuite.extract.api.model.shared.Fout
import net.atos.esuite.extract.api.validation.ValidNonNegativeInteger
import net.atos.esuite.extract.db.zakenmagazijn.repository.DocumentInhoudRepository
import org.apache.commons.io.IOUtils
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import java.io.OutputStream
import java.sql.Blob
import java.util.zip.ZipInputStream
import javax.sql.DataSource

@Path("documenten")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(mediaType = MediaType.APPLICATION_JSON, schema = Schema(implementation = Fout::class))]
)
class Documenten(
    private val documentInhoudRepository: DocumentInhoudRepository,
    private val dataSource: DataSource

) {
    @GET
    @Path("inhoud/{documentInhoudID}")
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
        content = [Content(mediaType = MediaType.APPLICATION_JSON, schema = Schema(implementation = Fout::class))]
    )
    @Transactional(Transactional.TxType.REQUIRED)
    fun documentInhoudRead(
        @PathParam("documentInhoudID")
        @Schema(description = "Interne identifier van document inhoud", implementation = Long::class)
        @ValidNonNegativeInteger
        documentInhoudID: String
    ): Response {
        val documentInhoudEntity = documentInhoudRepository.findById(documentInhoudID.toLong())
            ?: throw NotFoundException("Document inhoud with ID '$documentInhoudID' not found")
        val inhoud = documentInhoudEntity.inhoud
            ?: throw NotFoundException("Document inhoud with ID '$documentInhoudID' is empty")

        return ok(
            StreamingOutput { output: OutputStream ->
                try {
                    dataSource.connection.use { connection ->
                        connection.autoCommit = false
                        copyBlob(inhoud, documentInhoudEntity.compressed, output)
                    }
                } catch (e: Exception) {
                    throw WebApplicationException("Error occurred while processing Blob data", e)
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
