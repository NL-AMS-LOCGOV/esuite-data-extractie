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
    val vertrouwelijk: Boolean,

    @field:Schema(description = "Gebruikersnaam van behandelaar van zaak", maxLength = 64)
    val behandelaar: String?,

    @field:Schema(description = "Naam van afdeling waaraan zaak is toegekend", maxLength = 128)
    val afdeling: String?,

    @field:Schema(description = "Naam van groep waaraan zaak is toegekend", maxLength = 128)
    val groep: String?,

    @field:Schema(description = "Gebruikersnaam van medewerker welke zaak heeft aangemaakt", maxLength = 64)
    val aangemaaktDoor: String,

    @field:Schema(description = "Kanaal via welke zaak is binnengekomen")
    val kanaal: Kanaal,

    @field:Schema(description = "Tijdstip waarop zaak is aangemaakt", implementation = ZonedDateTime::class)
    val creatieDatumTijd: ZonedDateTime,

    @field:Schema(description = "Meest recente tijdstip waarop zaak is gewijzigd", implementation = ZonedDateTime::class )
    val wijzigDatumTijd: ZonedDateTime?,

    @field:Schema(description = "Datum waarop behandeling van zaak gestart is", implementation = LocalDate::class)
    val startdatum: LocalDate?,

    @field:Schema(description = "Streefdatum van zaak", implementation = LocalDate::class )
    val streefdatum: LocalDate,

    @field:Schema(description = "Fatale datum van zaak", implementation = LocalDate::class )
    val fataledatum: LocalDate?,

    @field:Schema(description = "Einddatum van zaak", implementation = LocalDate::class )
    val einddatum: LocalDate?,

    @field:Schema(description = "Huidige status van zaak")
    val zaakStatus: Zaakstatus,

    @field:Schema(description = "Resultaat van zaak")
    val resultaat: Resultaat?,

    @field:Schema(description = "Betaalgegevens gerelateerd aan zaak")
    val betaalgegevens: Betaalgegevens?,

    @field:Schema(description = "Is zaak een intake", required = true)
    val intake: Boolean,

    @field:Schema(description = "Archiveer gegevens van zaak")
    val archiveerGegevens: ArchiveerGegevens?,

    @field:Schema(description = "Archiveer gegevens van zaak")
    val geolocatie: GeografischeInformatie?,

    @field:Schema(description = "Historie van zaak")
    val historie: List<ZaakHistorie>,

    @field:Schema(description = "Zaak specifieke data")
    val zaakdata: List<ZaakData>?,

    @field:Schema(description = "Naam van organisatie")
    val organisatie: String?,

    @field:Schema(description = "Begindatum van een nu lopende opschorttermijn", implementation = LocalDate::class)
    val opschorttermijnStartdatum: LocalDate? = null,

    @field:Schema(description = "Einddatum van een nu lopende opschorttermijn", implementation = LocalDate::class)
    val opschorttermijnEinddatum: LocalDate? = null,

    @field:Schema(description = "Betreft dit een zaak met specifieke medewerker autorisatie", required = true)
    val geautoriseerdVoorMedewerkers: Boolean,

    @field:Schema(description = "Gebruikersnamen van medewerkers welke zijn geautoriseerd voor zaak")
    val geautoriseerdeMedewerkers: Set<String>?,

    @field:Schema(description = "Notities op zaak")
    val notities: List<ZaakNotitie>?,

    @field:Schema(description = "Is voor zaak afhandeling een proces gestart", required = true)
    val procesGestart: Boolean,

    @field:Schema(description = "Is zaak heropend nadat de zaak was beëindigd", required = true)
    val heropend: Boolean,

    @field:Schema(description = "Is zaak in vernietiging", required = true)
    val vernietiging: Boolean,

    @field:Schema(description = "Taken gerelateerd aan zaak")
    val taken: List<Taak>?,

    @field:Schema(description = "Betrokkenem gerelateerd aan zaak")
    val betrokkenen: List<ZaakBetrokkene>?,

    @field:Schema(description = "BAG Objecten gerelateerd aan zaak")
    val bagObjecten: List<BAGObject>?,

    @field:Schema(description = "Zaken gekoppeld aan zaak")
    val gekoppeldeZaken: List<ZaakZaakKoppeling>?,

    @field:Schema(description = "Documenen gerelateerd aan zaak")
    val documenten: List<Document>?,

    @field:Schema(description = "Besluiten gerelateerd aan zaak")
    val besluiten: List<Besluit>?,

    @field:Schema(description = "Contacten gerelateerd aan zaak")
    val contacten: List<ZaakContact>?,
    )
