package net.atos.esuite.extract.api.model.taak

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate
import java.time.ZonedDateTime

class Taak (
    @field:Schema(description = "Naam van afdeling waaraan taak is toegekend", maxLength = 128, required = false)
    val afdeling: String?,

    @field:Schema(description = "Functionele identificatie", maxLength = 128)
    val functioneelIdentificatie: String,

    @field:Schema(description = "Naam van groep waaraan taak is toegekend", maxLength = 128, required = false)
    val groep: String?,

    @field:Schema(description = "Gebruikersnaam van medewerker aan wie taak is toegekend", maxLength = 64, required = false)
    val behandelaar: String?,

    @field:Schema(description = "Startdatum van taak", implementation = LocalDate::class)
    val startdatum: LocalDate,

    @field:Schema(description = "Streefdatum van taak", implementation = LocalDate::class, required = false)
    val streefdatum: LocalDate?,

    @field:Schema(description = "Fatale datum van taak", implementation = LocalDate::class, required = false)
    val fataledatum: LocalDate?,

    @field:Schema(description = "Einddatum van taak", implementation = ZonedDateTime::class, required = false)
    val einddatum: ZonedDateTime?,

    @field:Schema(description = "Referentie van externe taak", maxLength = 255, required = false)
    val procesTaak: String?,

    @field:Schema(description = "Indicatie externe taak")
    val indicatieExternToegankelijk: Boolean,

    @field:Schema(description = "Naam van gebruiker, afdeling of groep die taak heeft afgehandeld", maxLength = 255, required = false)
    val afgehandeldDoor: String?,

    @field:Schema(maxLength = 255, required = false)
    val processtap: String?,

    @field:Schema(description = "Taaktype")
    val taaktype: Taaktype,

    @field:Schema(description = "Originele taaktype waarmee taak aangemaakt is")
    val taaktypeOrigineel: Taaktype,

    @field:Schema(description = "Datum vanaf taak is opgeschort", implementation = LocalDate::class, required = false)
    val opschorttermijnStartdatum: LocalDate?,

    @field:Schema(description = "Datum tot taak is opgeschort", implementation = LocalDate::class, required = false)
    val opschorttermijnEinddatum: LocalDate?,

    @field:Schema(description = "Historie van taak")
    val historie: List<TaakHistorie>,

    @field:Schema(description = "Emails voor notificatie/herinneringsemail voor een externe taak", required = false)
    val toekenningEmail: String?,

    @field:Schema(description = "Om taak te koppelen aan vestigingsnummer", required = false)
    val vestigingsnummer: String?,

    @field:Schema(description = "Om taak te koppelen aan KvK nummer", required = false)
    val kvkNummer: String?,

    @field:Schema(description = "Authenticatieniveau benodigd voor externen", maxLength = 4, required = false)
    val authenticatieniveau: String?,
)
