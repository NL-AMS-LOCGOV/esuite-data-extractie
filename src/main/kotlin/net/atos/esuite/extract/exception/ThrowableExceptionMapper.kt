package net.atos.esuite.extract.exception

import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider
import net.atos.esuite.extract.model.shared.Fout

@Provider
class ThrowableExceptionMapper : ExceptionMapper<Throwable> {

    override fun toResponse(throwable: Throwable): Response {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(Fout(throwable.message ?: "Unknown error: ${throwable.javaClass.simpleName}"))
            .build()
    }
}
