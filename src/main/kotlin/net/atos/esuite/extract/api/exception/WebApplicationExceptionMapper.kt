package net.atos.esuite.extract.api.exception

import jakarta.ws.rs.WebApplicationException
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider
import net.atos.esuite.extract.api.model.shared.Fout

@Provider
class WebApplicationExceptionMapper : ExceptionMapper<WebApplicationException> {

    override fun toResponse(exception: WebApplicationException): Response {
        return Response.status(exception.response.statusInfo)
            .entity(Fout(exception.message ?: "Unknown error"))
            .build()
    }
}
