package net.atos.esuite.extract.api.model.subject

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Contactpersoon(

    @field:Schema(description = "Naam", maxLength = 128, required = false)
    val naam: String?,

    @field:Schema(description = "Geslachtsaanduiding", required = false)
    val geslacht: Geslacht?,

    @field:Schema(description = "Emailadres", maxLength = 128, required = false)
    val emailadres: String?,

    @field:Schema(description = "Telefoonnummer", maxLength = 20, required = false)
    val telefoonnummer: String?,

    @field:Schema(description = "Telefaxnummer", maxLength = 20, required = false)
    val faxnummer: String?,

    @field:Schema(description = "Functie", maxLength = 64, required = false)
    val functie: String?,
)
