package net.atos.esuite.extract.model.basisgegevens

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Adres(

    @field:Schema(description = "Type adres")
    val type: AdresType,

    @field:Schema(description = "Straatnaam", maxLength = 64)
    val straatnaam: String?,

    @field:Schema(description = "Postcode", maxLength = 6)
    val postcode: String?,

    @field:Schema(description = "Plaatsnaam", maxLength = 128)
    val plaatsnaam: String?,

    @field:Schema(description = "Huisletter", maxLength = 10)
    val huisletter: String?,

    @field:Schema(description = "Huisnummer")
    val huisnummer: Int?,

    @field:Schema(description = "Huisnummertoevoeging", maxLength = 10)
    val huisnummertoevoeging: String?,

    @field:Schema(description = "Huisnummeraanduiding", maxLength = 64)
    val huisnummeraanduiding: String?,

    @field:Schema(description = "Adres buitenland 1", maxLength = 128)
    val adresbuitenland1: String?,

    @field:Schema(description = "Adres buitenland 2", maxLength = 128)
    val adresbuitenland2: String?,

    @field:Schema(description = "Adres buitenland 3", maxLength = 128)
    val adresbuitenland3: String?,

    @field:Schema(description = "Indicatie adres buitenland", required = true)
    val buitenlandsAdres: Boolean,

    @field:Schema(description = "Land", required = true)
    val land: Land,
)
