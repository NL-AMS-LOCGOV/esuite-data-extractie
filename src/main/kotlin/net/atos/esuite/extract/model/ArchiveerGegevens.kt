package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class ArchiveerGegevens (
    @field:Schema(description = "", implementation = LocalDate::class)
    val reviewTermijnEinddatum: LocalDate?,

    @field:Schema(description = "", implementation = LocalDate::class)
    val bewaartermijnEinddatum: LocalDate?,

    @field:Schema(description = "")
    val bewaartermijnWaardering: BewaartermijnWaardering?,

    @field:Schema(description = "", implementation = LocalDate::class)
    val overbrengenOp: LocalDate?,

    @field:Schema(description = "", maxLength = 255)
    val overbrengenNaar: String?,

    @field:Schema(description = "")
    val overbrengenDoor: Medewerker?,

    @field:Schema(description = "")
    val overgebrachteGegevens: OvergebrachteGegevens?,

    @field:Schema(description = "")
    val isBeperkingOpenbaarheid: Boolean?,

    @field:Schema(description = "")
    val beperkingOpenbaarheidReden: String?,

    @field:Schema(description = "", implementation = LocalDate::class)
    val beperkingOpenbaarheidVanaf: LocalDate?,

    @field:Schema(description = "", implementation = LocalDate::class)
    val beperkingOpenbaarheidTotEnMet: LocalDate?,

    @field:Schema(description = "", maxLength = 255)
    val selectielijstItemNaam: String?,

    @field:Schema(description = "")
    val overbrengenType: OverbrengenType?,
    )
