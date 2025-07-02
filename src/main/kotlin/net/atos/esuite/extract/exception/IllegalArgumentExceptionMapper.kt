package net.atos.esuite.extract.exception

import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider
import net.atos.esuite.extract.model.shared.Fout

@Provider
class IllegalArgumentExceptionMapper : ExceptionMapper<IllegalArgumentException> {

    override fun toResponse(exception: IllegalArgumentException): Response {
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(Fout(exception.message?:"Onbekende fout"))
            .build()
    }
}
