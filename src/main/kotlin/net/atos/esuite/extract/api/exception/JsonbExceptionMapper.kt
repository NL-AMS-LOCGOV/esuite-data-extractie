package net.atos.esuite.extract.api.exception

import jakarta.json.bind.JsonbException
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider
import net.atos.esuite.extract.api.model.shared.Fout

@Provider
class JsonbExceptionMapper : ExceptionMapper<JsonbException> {

    override fun toResponse(exception: JsonbException): Response {
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(Fout("Error parsing body: ${exception.cause?.message ?: exception.message}"))
            .build()
    }
}
