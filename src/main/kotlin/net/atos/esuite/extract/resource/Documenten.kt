package net.atos.esuite.extract.resource

import org.eclipse.microprofile.openapi.annotations.media.Content
import jakarta.annotation.Resource
import jakarta.transaction.UserTransaction
import jakarta.ws.rs.GET
import jakarta.ws.rs.NotFoundException
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.HttpHeaders
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.Response.ok
import jakarta.ws.rs.core.StreamingOutput
import net.atos.esuite.extract.model.shared.Fout
import net.atos.esuite.extract.repository.document.DocumentInhoudRepository
import org.apache.commons.io.IOUtils
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import java.io.OutputStream
import java.sql.Blob
import java.util.logging.Level
import java.util.logging.Logger
import java.util.zip.ZipInputStream
import org.eclipse.microprofile.openapi.annotations.media.Schema


@Path("documenten")
@APIResponse(responseCode = "401", description = "Unauthorized")
@APIResponse(
    responseCode = "500", description = "Internal Server Error",
    content = [Content(schema = Schema(implementation = Fout::class))]
)
class Documenten(
    @Resource private val userTransaction: UserTransaction,
    private val documentInhoudRepository: DocumentInhoudRepository
) {
    private val logger = Logger.getLogger(Documenten::class.java.getName())


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
            )])
    @APIResponse(
        responseCode = "404", description = "Not Found",
        content = [Content(schema = Schema(implementation = Fout::class))]
    )
    fun documentInhoudRead(@PathParam("documentInhoudID") documentInhoudID: Long): Response {
        userTransaction.setTransactionTimeout(300) // 5 minuten
        userTransaction.begin()
        val documentInhoudEntity = documentInhoudRepository.findById(documentInhoudID)
            ?: throw NotFoundException("Document inhoud with ID '$documentInhoudID' Not Found")
        val inhoud = documentInhoudEntity.inhoud
            ?: throw NotFoundException("Document inhoud with ID '$documentInhoudID' Is Empty")
        return ok(
            StreamingOutput { output: OutputStream ->
                try {
                    copyBlob(inhoud, documentInhoudEntity.compressed, output)
                    userTransaction.commit()
                } catch (e: Exception) {
                    userTransaction.rollback()
                    logger.log(Level.SEVERE, "Fout tijdens ophalen document inhoud", e)
                    error("Fout tijdens ophalen document inhoud")
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
