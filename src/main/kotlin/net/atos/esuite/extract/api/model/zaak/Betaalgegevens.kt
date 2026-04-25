package net.atos.esuite.extract.api.model.zaak

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

class Betaalgegevens (
    @field:Schema(description = "transactieId", maxLength = 64, required = false)
    val transactieId: String?,

    @field:Schema(description = "Een betalingskenmerk", maxLength = 64, required = false)
    val kenmerk: String?,

    @field:Schema(description = "Het bedrag", multipleOf = 0.000000001, maximum = "9999999999", required = false)
    val bedrag: BigDecimal?,

    @field:Schema(description = "Datum van de transactie", implementation = LocalDate::class, required = false)
    val transactieDatum: LocalDate?,

    @field:Schema(description = "Foutcode", maxLength = 64, required = false)
    val ncerror: String?,

    @field:Schema(description = "Originele statuscode van de betaling", maxLength = 64, required = false)
    val origineleStatusCode: String?,

    @field:Schema(description = "Transactiestatus van de betaling", required = false)
    val betaalstatus: Betaalstatus?,
)
