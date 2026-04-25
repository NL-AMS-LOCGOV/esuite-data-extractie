package net.atos.esuite.extract.api.model.zaak

import net.atos.esuite.extract.api.model.bag.BAGObject
import net.atos.esuite.extract.api.model.besluit.Besluit
import net.atos.esuite.extract.api.model.document.Document
import net.atos.esuite.extract.api.model.dsr.domein.DomeinObject
import net.atos.esuite.extract.api.model.geojson.Geometry
import net.atos.esuite.extract.api.model.shared.Kanaal
import net.atos.esuite.extract.api.model.subject.Subject
import net.atos.esuite.extract.api.model.taak.Taak
import net.atos.esuite.extract.api.model.zaakdata.DataElement
import net.atos.esuite.extract.api.model.zaaktype.ZaaktypeOverzicht
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate
import java.time.ZonedDateTime

class Zaak(
    @field:Schema(description = "Zaaknummer in e-Suite", maxLength = 128)
    val functioneleIdentificatie: String,

    @field:Schema(
        description = "Identificatie van zaak welke kan worden gebruikt bij koppelen met extern systeem",
        minLength = 5,
        maxLength = 40
    )
    val externeIdentificatie: String,

    @field:Schema(description = "Omschrijving van zaak")
    val omschrijving: String,

    @field:Schema(description = "Reden voor starten van zaak", required = false)
    val redenStart: String?,

    @field:Schema(description = "Zaaktype")
    val zaaktype: ZaaktypeOverzicht,

    @field:Schema(description = "Is zaak vertrouwelijk")
    val vertrouwelijk: Boolean,

    @field:Schema(description = "Gebruikersnaam van behandelaar van zaak", maxLength = 64, required = false)
    val behandelaar: String?,

    @field:Schema(description = "Initiator van zaak", required = false)
    val initiator: Subject?,

    @field:Schema(description = "Naam van afdeling waaraan zaak is toegekend", maxLength = 128, required = false)
    val afdeling: String?,

    @field:Schema(description = "Naam van groep waaraan zaak is toegekend", maxLength = 128, required = false)
    val groep: String?,

    @field:Schema(description = "Gebruikersnaam van medewerker welke zaak heeft aangemaakt", maxLength = 64)
    val aangemaaktDoor: String,

    @field:Schema(description = "Kanaal via welke zaak is binnengekomen")
    val kanaal: Kanaal,

    @field:Schema(description = "Tijdstip waarop zaak is aangemaakt", implementation = ZonedDateTime::class)
    val creatieDatumTijd: ZonedDateTime,

    @field:Schema(
        description = "Meest recente tijdstip waarop zaak is gewijzigd",
        implementation = ZonedDateTime::class, required = false
    )
    val wijzigDatumTijd: ZonedDateTime?,

    @field:Schema(description = "Datum waarop behandeling van zaak gestart is", implementation = LocalDate::class, required = false)
    val startdatum: LocalDate?,

    @field:Schema(description = "Streefdatum van zaak", implementation = LocalDate::class)
    val streefdatum: LocalDate,

    @field:Schema(description = "Fatale datum van zaak", implementation = LocalDate::class, required = false)
    val fataledatum: LocalDate?,

    @field:Schema(description = "Einddatum van zaak", implementation = LocalDate::class, required = false)
    val einddatum: LocalDate?,

    @field:Schema(description = "Huidige status van zaak")
    val zaakStatus: Zaakstatus,

    @field:Schema(description = "Resultaat van zaak", required = false)
    val resultaat: Resultaat?,

    @field:Schema(description = "Betaalgegevens gerelateerd aan zaak", required = false)
    val betaalgegevens: Betaalgegevens?,

    @field:Schema(description = "Is zaak een intake")
    val intake: Boolean,

    @field:Schema(description = "Archiveer gegevens van zaak", required = false)
    val archiveerGegevens: ArchiveerGegevens?,

    @field:Schema(description = "Locatie van zaak. Coördinatenstelsel is RD_NEW (srid=28992)", required = false)
    val geolocatie: Geometry?,

    @field:Schema(description = "Historie van zaak")
    val historie: List<ZaakHistorie>,

    @field:Schema(description = "Zaak specifieke data", required = false)
    val zaakdata: List<DataElement>?,

    @field:Schema(description = "Naam van organisatie", required = false)
    val organisatie: String?,

    @field:Schema(description = "Begindatum van een nu lopende opschorttermijn", implementation = LocalDate::class, required = false)
    val opschorttermijnStartdatum: LocalDate? = null,

    @field:Schema(description = "Einddatum van een nu lopende opschorttermijn", implementation = LocalDate::class, required = false)
    val opschorttermijnEinddatum: LocalDate? = null,

    @field:Schema(description = "Betreft dit een zaak met specifieke medewerker autorisatie")
    val geautoriseerdVoorMedewerkers: Boolean,

    @field:Schema(description = "Gebruikersnamen van medewerkers welke zijn geautoriseerd voor zaak", required = false)
    val geautoriseerdeMedewerkers: Set<String>?,

    @field:Schema(description = "Notities op zaak", required = false)
    val notities: List<ZaakNotitie>?,

    @field:Schema(description = "Is voor zaak afhandeling een proces gestart")
    val procesGestart: Boolean,

    @field:Schema(description = "Datum tijd waarop de zaak gemigreerd is van ZTC1 naar ZTC2", implementation = ZonedDateTime::class, required = false)
    val ztc1MigratiedatumTijd: ZonedDateTime?,

    @field:Schema(description = "Is zaak heropend nadat de zaak was beëindigd")
    val heropend: Boolean,

    @field:Schema(description = "Is zaak open (nog niet beëindigd)")
    val open: Boolean,

    @field:Schema(description = "Is zaak in vernietiging")
    val vernietiging: Boolean,

    @field:Schema()
    val notificeerbaar: Boolean,

    @field:Schema(description = "Taken gerelateerd aan zaak", required = false)
    val taken: List<Taak>?,

    @field:Schema(description = "Betrokkenen gerelateerd aan zaak", required = false)
    val betrokkenen: List<ZaakBetrokkene>?,

    @field:Schema(description = "BAG Objecten gerelateerd aan zaak", required = false)
    val bagObjecten: List<BAGObject>?,

    @field:Schema(description = "Zaken gekoppeld aan zaak", required = false)
    val gekoppeldeZaken: List<ZaakZaakKoppeling>?,

    @field:Schema(description = "Documenen gerelateerd aan zaak", required = false)
    val documenten: List<Document>?,

    @field:Schema(description = "Besluiten gerelateerd aan zaak", required = false)
    val besluiten: List<Besluit>?,

    @field:Schema(description = "Functionele identificatie van contacten gerelateerd aan zaak", required = false)
    val contacten: List<String>?,

    @field:Schema(description = "Domein Objecten gerelateerd aan zaak", required = false)
    val domeinObjecten: List<DomeinObject>?,

    @field:Schema(description = "Is zaak gemigreerd naar PodiumD", required = true)
    val gemigreerd: Boolean = false,

    @field:Schema(description = "Tijdstip waarop zaak gemigreerd is naar PodiumD", implementation = ZonedDateTime::class, required = false)
    val podiumdMigratieTijdstip: ZonedDateTime?,
)
