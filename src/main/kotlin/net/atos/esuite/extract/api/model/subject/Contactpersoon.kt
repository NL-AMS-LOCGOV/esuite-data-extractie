package net.atos.esuite.extract.api.model.subject

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Contactpersoon(

    @field:Schema(description = "Naam", maxLength = 128)
    val naam: String?,

    @field:Schema(description = "Geslachtsaanduiding")
    val geslacht: Geslacht?,

    @field:Schema(description = "Emailadres", maxLength = 128)
    val emailadres: String?,

    @field:Schema(description = "Telefoonnummer", maxLength = 20)
    val telefoonnummer: String?,

    @field:Schema(description = "Telefaxnummer", maxLength = 20)
    val faxnummer: String?,

    @field:Schema(description = "Functie", maxLength = 64)
    val functie: String?,
)
