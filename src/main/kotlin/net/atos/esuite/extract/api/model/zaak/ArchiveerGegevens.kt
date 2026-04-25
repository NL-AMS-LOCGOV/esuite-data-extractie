package net.atos.esuite.extract.api.model.zaak

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class ArchiveerGegevens (
    @field:Schema(description = "", implementation = LocalDate::class, required = false)
    val reviewTermijnEinddatum: LocalDate?,

    @field:Schema(description = "Datum waarop de bewaartermijn afloopt", implementation = LocalDate::class, required = false)
    val bewaartermijnEinddatum: LocalDate?,

    @field:Schema(description = "Waardering van de bewaartermijn", required = false)
    val bewaartermijnWaardering: BewaartermijnWaardering?,

    @field:Schema(description = "Datum waarop de zaak overgebracht moet worden", implementation = LocalDate::class, required = false)
    val overbrengenOp: LocalDate?,

    @field:Schema(description = "Locatie/instantie waarnaar zaak overgebracht moet worden", maxLength = 255, required = false)
    val overbrengenNaar: String?,

    @field:Schema(description = "Naam medewerker die zaak op overbrengen zet", maxLength = 128, required = false)
    val overbrengenDoor: String?,

    @field:Schema(description = "Overgebrachte gegevens", required = false)
    val overgebrachteGegevens: OvergebrachteGegevens?,

    @field:Schema(description = "Aanduiding beperking openbaarheid", required = false)
    val beperkingOpenbaarheid: Boolean?,

    @field:Schema(description = "Reden beperking openbaarheid", required = false)
    val beperkingOpenbaarheidReden: String?,

    @field:Schema(description = "Beperking openbaarheid datum vanaf", implementation = LocalDate::class, required = false)
    val beperkingOpenbaarheidVanaf: LocalDate?,

    @field:Schema(description = "Beperking openbaarheid datum tot en met", implementation = LocalDate::class, required = false)
    val beperkingOpenbaarheidTotEnMet: LocalDate?,

    @field:Schema(description = "Naam van het zaaktype (zaaktype: naam_algemeen)", maxLength = 255, required = false)
    val zaaktypeNaam: String?,

    @field:Schema(description = "", maxLength = 255, required = false)
    val selectielijstItemNaam: String?,

    @field:Schema(description = "Type overbrengen", required = false)
    val overbrengenType: OverbrengenType?,
    )
