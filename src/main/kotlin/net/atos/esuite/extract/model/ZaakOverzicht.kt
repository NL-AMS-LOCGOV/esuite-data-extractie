package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class ZaakOverzicht(
    @get:Schema(description = "Technische identificatie van zaak")
    var id: Long,

    @get:Schema(description = "String of max length 14 characters", maxLength = 10)
    var omschrijving: String?,

    @get:Schema(description = "Zaaktype", maxLength = 100)
    var zaaktype: String?
)


