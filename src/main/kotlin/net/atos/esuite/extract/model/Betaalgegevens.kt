package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

class Betaalgegevens (
    @field:Schema(description = "transactieId", maxLength = 64)
    val transactieId: String?,

    @field:Schema(description = "Een betalingskenmerk", maxLength = 64)
    val kenmerk: String?,

    @field:Schema(description = "Het bedrag", multipleOf = 0.000000001, maximum = "9999999999")
    val bedrag: BigDecimal?,

    @field:Schema(description = "Datum van de transactie", implementation = LocalDate::class)
    val transactieDatum: LocalDate?,

    @field:Schema(description = "Foutcode", maxLength = 64)
    val ncerror: String?,

    @field:Schema(description = "Originele statuscode van de betaling", maxLength = 64)
    val origineleStatusCode: String?,

    @field:Schema(description = "Transactiestatus van de betaling")
    val betaalstatus: Betaalstatus?,
)
