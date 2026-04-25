package net.atos.esuite.extract.api.model.subject

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Adres(

    @field:Schema(description = "Type adres")
    val type: AdresType,

    @field:Schema(description = "Straatnaam", maxLength = 64, required = false)
    val straatnaam: String?,

    @field:Schema(description = "Postcode", maxLength = 6, required = false)
    val postcode: String?,

    @field:Schema(description = "Plaatsnaam", maxLength = 128, required = false)
    val plaatsnaam: String?,

    @field:Schema(description = "Huisletter", maxLength = 10, required = false)
    val huisletter: String?,

    @field:Schema(description = "Huisnummer", required = false)
    val huisnummer: Int?,

    @field:Schema(description = "Huisnummertoevoeging", maxLength = 10, required = false)
    val huisnummertoevoeging: String?,

    @field:Schema(description = "Huisnummeraanduiding", maxLength = 64, required = false)
    val huisnummeraanduiding: String?,

    @field:Schema(description = "Adres buitenland 1", maxLength = 128, required = false)
    val adresbuitenland1: String?,

    @field:Schema(description = "Adres buitenland 2", maxLength = 128, required = false)
    val adresbuitenland2: String?,

    @field:Schema(description = "Adres buitenland 3", maxLength = 128, required = false)
    val adresbuitenland3: String?,

    @field:Schema(description = "Indicatie adres buitenland")
    val buitenlandsAdres: Boolean,

    @field:Schema(description = "Land")
    val land: Land,
)
