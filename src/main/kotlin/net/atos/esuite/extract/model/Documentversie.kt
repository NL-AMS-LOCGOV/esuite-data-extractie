package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class Documentversie(
    @field:Schema(description = "Versienummer van document versie", required = true)
    val versienummer: Int,

    @field:Schema(description = "ID van het bestand dat de inhoud van document versie bevat in het DMS", maxLength = 255)
    val bestandsId: String,

    @field:Schema(description = "Datum waarop document versie werd aangemaakt", implementation = LocalDate::class)
    val creatiedatum: LocalDate,

    @field:Schema(description = "Naam van auteur", maxLength = 128)
    val auteur: String?,

    @field:Schema(description = "Naam van afzender", maxLength = 128)
    val afzender: String?,

    @field:Schema(description = "Bestandsnaam van document versie", maxLength = 255)
    val bestandsnaam: String,

    @field:Schema(description = "Mimetype van document versie", maxLength = 255)
    val mimetype: String,

    @field:Schema(description = "Ondertekeningen van document vdersie")
    val ondertekeningen: List<DocumentOndertekening>?,

    @field:Schema(description = "Grootte van document in bytes")
    val documentgrootte: Long?,

    @field:Schema(description = "Indicatie of de Blob gecomprimeerd is opgeslagen", required = true)
    val compressed: Boolean,
    )
