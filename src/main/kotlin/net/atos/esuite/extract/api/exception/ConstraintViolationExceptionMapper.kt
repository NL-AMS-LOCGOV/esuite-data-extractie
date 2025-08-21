package net.atos.esuite.extract.api.exception

import jakarta.validation.ConstraintViolationException
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider
import net.atos.esuite.extract.api.model.shared.ValidatieFout
import net.atos.esuite.extract.api.model.shared.ValidatieFouten

@Provider
class ConstraintViolationExceptionMapper : ExceptionMapper<ConstraintViolationException> {

    override fun toResponse(exception: ConstraintViolationException): Response {
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(
                ValidatieFouten(
                    exception.constraintViolations.map {
                        ValidatieFout(
                            message = it.message,
                            field = it.propertyPath.toString(),
                            value = it.invalidValue?.toString() ?: "null"
                        )
                    }
                ))
            .build()
    }
}
