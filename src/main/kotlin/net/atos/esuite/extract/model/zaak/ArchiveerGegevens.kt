package net.atos.esuite.extract.model.zaak

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class ArchiveerGegevens (
    @field:Schema(description = "", implementation = LocalDate::class)
    val reviewTermijnEinddatum: LocalDate?,

    @field:Schema(description = "Datum waarop de bewaartermijn afloopt", implementation = LocalDate::class)
    val bewaartermijnEinddatum: LocalDate?,

    @field:Schema(description = "Waardering van de bewaartermijn")
    val bewaartermijnWaardering: BewaartermijnWaardering?,

    @field:Schema(description = "Datum waarop de zaak overgebracht moet worden", implementation = LocalDate::class)
    val overbrengenOp: LocalDate?,

    @field:Schema(description = "Locatie/instantie waarnaar zaak overgebracht moet worden", maxLength = 255)
    val overbrengenNaar: String?,

    @field:Schema(description = "Naam medewerker die zaak op overbrengen zet", maxLength = 128)
    val overbrengenDoor: String?,

    @field:Schema(description = "")
    val overgebrachteGegevens: OvergebrachteGegevens?,

    @field:Schema(description = "Aanduiding beperking openbaarheid")
    val beperkingOpenbaarheid: Boolean?,

    @field:Schema(description = "Reden beperking openbaarheid")
    val beperkingOpenbaarheidReden: String?,

    @field:Schema(description = "Beperking openbaarheid datum vanaf", implementation = LocalDate::class)
    val beperkingOpenbaarheidVanaf: LocalDate?,

    @field:Schema(description = "Beperking openbaarheid datum tot en met", implementation = LocalDate::class)
    val beperkingOpenbaarheidTotEnMet: LocalDate?,

    @field:Schema(description = "Naam van het zaaktype (zaaktype: naam_algemeen)", maxLength = 255)
    val zaaktypeNaam: String?,

    @field:Schema(description = "", maxLength = 255)
    val selectielijstItemNaam: String?,

    @field:Schema(description = "Type overbrengen")
    val overbrengenType: OverbrengenType?,
    )
