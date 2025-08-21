package net.atos.esuite.extract.exception

import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider
import net.atos.esuite.extract.model.shared.Fout
import java.util.logging.Level
import java.util.logging.Logger

@Provider
class ThrowableExceptionMapper : ExceptionMapper<Throwable> {

    private val logger = Logger.getLogger(ThrowableExceptionMapper::class.qualifiedName)

    override fun toResponse(throwable: Throwable): Response {
        logger.log(Level.SEVERE, "Internal server error: ${throwable.message}", throwable)
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(Fout(throwable.message ?: "Unknown error: ${throwable.javaClass.simpleName}"))
            .build()
    }
}
