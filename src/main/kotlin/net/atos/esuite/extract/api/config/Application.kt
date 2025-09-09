package net.atos.esuite.extract.api.config

import jakarta.ws.rs.core.Application
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeIn
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType
import org.eclipse.microprofile.openapi.annotations.info.Contact
import org.eclipse.microprofile.openapi.annotations.info.Info
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme


@OpenAPIDefinition(
    info = Info(
        title = "e-Suite data extractie API",
        version = "0.12.0",
        contact = Contact(
            name = "Andy Verberne",
            email = "andy.verberne@atos.net"
        ),
    ),
    security = [
        SecurityRequirement(
            name = "ApiKeyAuth",
        )
    ]
)
@SecurityScheme(
    securitySchemeName = "ApiKeyAuth",
    type = SecuritySchemeType.APIKEY,
    `in` = SecuritySchemeIn.HEADER,
    apiKeyName = "X-API-KEY",
    description = "API key for authentication"
)
class Application : Application() {
}
