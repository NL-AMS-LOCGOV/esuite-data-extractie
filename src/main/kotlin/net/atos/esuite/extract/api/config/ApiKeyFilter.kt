package net.atos.esuite.extract.api.config

import jakarta.annotation.Priority
import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.Priorities
import jakarta.ws.rs.container.ContainerRequestContext
import jakarta.ws.rs.container.ContainerRequestFilter
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.Provider
import org.eclipse.microprofile.config.inject.ConfigProperty

@Provider
@Priority(Priorities.AUTHENTICATION)
@ApplicationScoped
class ApiKeyFilter : ContainerRequestFilter {

    @ConfigProperty(name = "api.key")
    lateinit var apiKey: String

    override fun filter(requestContext: ContainerRequestContext) {
        // Skip OPTIONS requests (for CORS)
        if (requestContext.method == "OPTIONS") {
            return
        }

        // Skip OpenAPI endpoint
        val path = requestContext.uriInfo.path
        if (path.startsWith("q/openapi")) {
            return
        }

        val providedApiKey = requestContext.headers.getFirst("X-API-KEY")

        if (providedApiKey == null || providedApiKey != apiKey) {
            requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid or missing API key")
                    .build()
            )
        }
    }
}
