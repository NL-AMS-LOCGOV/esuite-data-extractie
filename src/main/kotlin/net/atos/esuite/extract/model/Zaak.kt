package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate
import java.time.ZonedDateTime

class Zaak(
    @field:Schema(description = "Zaaknummer in e-Suite", maxLength = 128)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Identificatie van zaak welke kan worden gebruikt bij koppelen met extern systeem", minLength = 5, maxLength = 40)
    val externeIdentificatie: String,

    @field:Schema(description = "Omschrijving van zaak")
    val omschrijving: String,

    @field:Schema(description = "Reden voor starten van zaak")
    val redenStart: String?,

    @field:Schema(description = "Zaaktype")
    val zaaktype: Zaaktype,

    @field:Schema(description = "Is zaak vertrouwelijk", required = true)
    val isVertrouwelijk: Boolean,

    @field:Schema(description = "Behandelaar van zaak")
    val behandelaar: Medewerker?,

    @field:Schema(description = "Naam van afdeling waaraan zaak is toegekend", maxLength = 64)
    val afdeling: String?,

    @field:Schema(description = "Naam van groep waaraan zaak is toegekend", maxLength = 64)
    val groep: String?,

    @field:Schema(description = "Medewerker welke zaak heeft aangemaakt")
    val aangemaaktDoor: Medewerker,

    @field:Schema(description = "Naam van kanaal via welke zaak is binnengekomen", maxLength = 255)
    val kanaal: String?,

    @field:Schema(description = "Tijdstip waarop zaak is aangemaakt", implementation = ZonedDateTime::class)
    val creatieTijdstip: ZonedDateTime,

    @field:Schema(description = "Meest recente tijdstip waarop zaak is gewijzigd", implementation = ZonedDateTime::class )
    val wijzigTijdstip: ZonedDateTime,

    @field:Schema(description = "", implementation = LocalDate::class)
    val startdatum: LocalDate,

    @field:Schema(description = "", implementation = LocalDate::class )
    val streefdatum: LocalDate,

    @field:Schema(description = "", implementation = LocalDate::class )
    val fataledatum: LocalDate?,

    @field:Schema(description = "", implementation = LocalDate::class )
    val einddatum: LocalDate?,

    @field:Schema(description = "Huidige status van zaak")
    val status: Zaakstatus,

    @field:Schema(description = "Resultaat van zaak")
    val resultaat: Zaakresultaat?,

    @field:Schema(description = "Betaalgegevens gerelateerd aan zaak")
    val betaalgegevens: Betaalgegevens?,

    @field:Schema(description = "Is zaak een intake", required = true)
    val isIntake: Boolean,

    @field:Schema(description = "Archiveer gegevens van zaak")
    val archiveerGegevens: ArchiveerGegevens?,

    @field:Schema(description = "Archiveer gegevens van zaak")
    val geolocatie: GeografischeInformatie?,

    @field:Schema(description = "Historie van zaak")
    val historie: Set<ZaakHistorie>?,

    @field:Schema(description = "Zaak details")
    val details: Set<ZaakData>?,

    // ToDo: Is het mogelijk hier een RSIN mee te geven?
    @field:Schema(description = "Naam van organisatie. RSIN?")
    val organisatie: String?,

    @field:Schema(description = "")
    val opschorttermijn: Opschorttermijn?,

    @field:Schema(description = "Medewerkers welke zijn geautoriseerd voor zaak. Indien aanwezig betreft dit dus een zaak met specifieke medewerker autorisatie")
    val geautoriseerdeMedewerkers: Set<Medewerker>?,

    @field:Schema(description = "Notities op zaak")
    val notities: List<ZaakNotitie>?,

    @field:Schema(description = "Is voor zaak afhandeling een proces gestart", required = true)
    val isProcesGestart: Boolean,

    @field:Schema(description = "", required = true)
    val isHeropend: Boolean,

    @field:Schema(description = "", required = true)
    val isVernietiging: Boolean,

    @field:Schema(description = "")
    val taken: List<Taak>?,

    @field:Schema(description = "")
    val betrokkenen: List<ZaakBetrokkene>?,

    @field:Schema(description = "")
    val bagObjecten: List<BAGObject>?,

    @field:Schema(description = "")
    val gekoppeldeZaken: List<GekoppeldeZaak>?,

    @field:Schema(description = "")
    val documenten: List<Document>?,

    @field:Schema(description = "")
    val besluiten: List<Besluit>?,
    )
