package net.atos.esuite.extract.api.model.document

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class Documentversie(
    @field:Schema(description = "Versienummer van document versie")
    val versienummer: Int,

    @field:Schema(description = "ID van document versie inhoud")
    val documentInhoudID: Long,

    @field:Schema(description = "Datum waarop document versie werd aangemaakt", implementation = LocalDate::class)
    val creatiedatum: LocalDate,

    @field:Schema(description = "Naam van auteur", maxLength = 128, required = false)
    val auteur: String?,

    @field:Schema(description = "Naam van afzender", maxLength = 128, required = false)
    val afzender: String?,

    @field:Schema(description = "Bestandsnaam van document versie", maxLength = 255)
    val bestandsnaam: String,

    @field:Schema(description = "Mimetype van document versie", maxLength = 255)
    val mimetype: String,

    @field:Schema(description = "Ondertekeningen van document versie", required = false)
    val ondertekeningen: List<DocumentOndertekening>?,

    @field:Schema(description = "Grootte van document versie in bytes", required = false)
    val documentgrootte: Long?,

    @field:Schema(description = "Indicatie of document versie gecomprimeerd is opgeslagen")
    val compressed: Boolean,
    )
