package net.atos.esuite.extract.api.model.zaaktype

import net.atos.esuite.extract.api.model.document.DocumentTag
import net.atos.esuite.extract.api.model.shared.Referentie
import net.atos.esuite.extract.api.model.taak.TaakDocumentGroep
import net.atos.esuite.extract.api.model.zaak.Zaakstatus
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

@Schema(allOf = [Referentie::class])
class Zaaktype(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Functionele identificatie", maxLength = 128)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Actie die uitgevoerd wordt om zaak of proces te starten")
    val handelingInitiator: HandelingInitiator,

    @field:Schema(description = "Is zaak voor intern of extern gebruik")
    val internExtern: InternExtern,

    @field:Schema(description = "Categorie waarin zaak valt")
    val categorie: Categorie,

    @field:Schema(description = "Informatie voor Derden Categorie waarin zaak valt")
    val iv3categorie: Iv3Categorie,

    @field:Schema(description = "Naam van afdeling waaraan nieuwe zaak wordt toegekend", maxLength = 255, required = false)
    val afdeling: String?,

    @field:Schema(description = "Naam van groep waaraan nieuwe zaak wordt toegekend", maxLength = 255, required = false)
    val groep: String?,

    @field:Schema(description = "Is zaak een intake")
    val intake: Boolean,

    @field:Schema(description = "Datum begin geldigheid", implementation = LocalDate::class)
    val beginGeldigheidDatum: LocalDate,

    @field:Schema(description = "Datum einde geldigheid", implementation = LocalDate::class, required = false)
    val eindeGeldigheidDatum: LocalDate?,

    @field:Schema(description = "Gewenste doorlooptijd in dagen", required = false)
    val doorlooptijdGewenst: Int?,

    @field:Schema(description = "Maximale doorlooptijd in dagen", required = false)
    val doorlooptijdVereist: Int?,

    @field:Schema(description = "Is aanpassen van doorlooptijd van zaak toegestaan")
    val doorlooptijdAanpassenToegestaan: Boolean,

    @field:Schema(description = "Aantal dagen voorafgaand aan de streefdatum waarop de 1ste signalering plaats vindt")
    val aantalDagenVoorStreefdatumVoorEersteSignalering: Int,

    @field:Schema(description = "Aantal dagen voorafgaand aan de streefdatum waarop de 2de signalering plaats vindt")
    val aantalDagenVoorStreefdatumVoorTweedeSignalering: Int,

    @field:Schema(description = "Aantal dagen voorafgaand aan de fataledatum waarop de 1ste signalering plaats vindt")
    val aantalDagenVoorFataledatumVoorEersteSignalering: Int,

    @field:Schema(description = "Aantal dagen voorafgaand aan de fataledatum waarop de 2de signalering plaats vindt")
    val aantalDagenVoorFataledatumVoorTweedeSignalering: Int,

    @field:Schema(description = "Initiele status van nieuwe zaak", required = false)
    val status: Zaakstatus?,

    @field:Schema(description = "Archivering reviewperiode in weken", required = false)
    val archiveringReviewPeriode: Int?,

    @field:Schema(description = "Moet proces gestart worden bij aanmaken van nieuwe zaak")
    val startenProces: Boolean,

    @field:Schema(description = "Functionele identificatie van proces dat wordt gestart", maxLength = 128, required = false)
    val proces: String?,

    @field:Schema(description = "Functionele identificatie van zaak startformulier", maxLength = 128, required = false)
    val startformulier: String?,

    @field:Schema(description = "Versie nummer van zaak startformulier", required = false)
    val startformulierVersie: Long?,

    @field:Schema(description = "Is zaak vertrouwelijk")
    val vertrouwelijk: Boolean,

    @field:Schema(description = "Mogelijke authenticatie methoden bij aanmaken nieuwe zaak", required = false)
    val authenticaties: List<ZaaktypeAuthenticatie>?,

    @field:Schema(description = "Betreft dit een zaak met specifieke medewerker autorisatie")
    val geautoriseerdVoorMedewerkers: Boolean,

    @field:Schema(description = "Gebruikersnamen van medewerkers welke zijn geautoriseerd voor zaak", required = false)
    val geautoriseerdeMedewerkers: Set<String>?,

    @field:Schema(description = "Moet er notificaties worden verstuurd voor de zaak")
    val notificatiesVersturen: Boolean,

    @field:Schema(description = "Mogelijke statussen van zaak", required = false)
    val statussen: List<Zaakstatus>?,

    @field:Schema(description = "Mogelijke resultaten van zaak", required = false)
    val resultaten: List<ZaaktypeResultaat>?,

    @field:Schema(description = "Mogelijke besluiten bij zaak", required = false)
    val besluiten: List<ZaaktypeBesluittype>?,

    @field:Schema(description = "Mogelijke documenttypen van documenten bij zaak", required = false)
    val documenttypen: List<ZaaktypeDocumenttype>?,

    @field:Schema(description = "Tags welke gezet kunnen worden op documenten bij zaak", required = false)
    val documentTags: List<DocumentTag>?,

    @field:Schema(description = "Zaaktypen waarvan zaken gekoppeld kunnen worden aan zaak", required = false)
    val gekoppeldeZaaktypen: List<ZaaktypeOverzicht>?,

    @field:Schema(description = "Taakdocument groepen", required = false)
    val taakDocumentGroepen: List<TaakDocumentGroep>?,

    @field:Schema(description = "Naam voor het samenvatting document", maxLength = 255)
    val samenvattingDocumentNaam: String,

    @field:Schema(description = "Zaak start parameters", required = false)
    val zaakStartParameters: List<ZaakStartParameter>?,

    @field:Schema(description = "Productaanvraagtype", maxLength = 255, required = false)
    val productaanvraagtype: String?,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
