package net.atos.esuite.extract.api.model.subject

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

@Schema(allOf = [Subject::class])
class Persoon(
    identifier: Long,
    notities: List<SubjectNotitie>?,
    telefoonnummer: String?,
    telefoonnummerAlternatief: String?,
    emailadres: String?,
    rekeningnummer: String?,
    ontvangenZaakNotificaties: Boolean?,
    toestemmingZaakNotificatiesAlleenDigitaal: Boolean?,
    handmatigToegevoegd: Boolean,
    adressen: List<Adres>?,

    @field:Schema(description = "Burgerservicenummer (BSN)", minLength = 9, maxLength = 9)
    val burgerServiceNummer: String?,

    @field:Schema(description = "Voornamen", maxLength = 200)
    val voornamen: String?,

    @field:Schema(description = "Voorletters", maxLength = 20)
    val voorletters: String?,

    @field:Schema(description = "Achternaam", maxLength = 200)
    val geslachtsNaam: String?,

    @field:Schema(description = "Voorvoegsel geslachtsnaam", maxLength = 10)
    val voorvoegsel: String?,

    @field:Schema(description = "Geslachtsaanduiding")
    val geslacht: Geslacht?,

    @field:Schema(description = "Aanhef van de aanschrijving", maxLength = 64)
    val aanhefAanschrijving: String?,

    @field:Schema(description = "Adelijke titel", maxLength = 10)
    val adelijkeTitel: String?,

    @field:Schema(description = "Aanduiding pre academische titel", maxLength = 20)
    val preAcademischeTitel: String?,

    @field:Schema(description = "Aanduiding post academische titel", maxLength = 20)
    val postAcademischeTitel: String?,

    @field:Schema(description = "Aanduiding van naamgebruik")
    val naamgebruik: Naamgebruik?,

    @field:Schema(description = "Achternaam partner", maxLength = 200)
    val geslachtsNaamPartner: String?,

    @field:Schema(description = "Voorvoegsel geslachtsnaam partner", maxLength = 10)
    val voorvoegselPartner: String?,

    @field:Schema(description = "Geboortedatum", implementation = LocalDate::class)
    val geboortedatum: LocalDate? = null,

    @field:Schema(description = "Geboorteplaats", maxLength = 255)
    val geboorteplaats: String?,

    @field:Schema(description = "Overlijdensdatum", implementation = LocalDate::class)
    val overlijdensdatum: LocalDate? = null,

    @field:Schema(description = "Overlijdensplaats", maxLength = 255)
    val overlijdensplaats: String?,

    @field:Schema(description = "Gemeentelijk A-nummer", maxLength = 10)
    val aNummer: String?,

    @field:Schema(description = "Reden opschorting bijhouding adresgegevens")
    val opschortingsReden: OpschortingsReden?,

    @field:Schema(description = "Datum opschorting bijhouding adresgegevens", implementation = LocalDate::class)
    val opschortingsDatum: LocalDate? = null,

    @field:Schema(description = "Indicatie blokkering tijdens verhuizing", required = true)
    val geblokkeerd: Boolean,

    @field:Schema(description = "Indicatie gezag- of curatelestelling", required = true)
    val curateleRegister: Boolean,

    @field:Schema(description = "Indicatie of er een onderzoek naar de persoon wordt uitgevoerd", required = true)
    val inOnderzoek: Boolean,

    @field:Schema(description = "Indicatie of de geboortedatum volledig is")
    val geboortedatumVolledig: OnvolledigeDatumType?,

    @field:Schema(description = "Indicatie of datum van overlijden volledig is")
    val overlijdensdatumVolledig: OnvolledigeDatumType?,

    @field:Schema(description = "Indicatie beperking verstrekking gegevens", required = true)
    val beperkingVerstrekking: Boolean,

    @field:Schema(description = "Indicatie niet-ingezetene")
    val nietIngezeteneAanduiding: NietIngezeteneAanduiding?,

    @field:Schema(description = "Indicatie of de persoon geabonneerd is op updates vanuit de makelaar", required = true)
    val afnemerIndicatie: Boolean,

    @field:Schema(description = "Ander Natuurlijk Persoon (ANP) identificatie gebruikt tijdens verwerking van StUF-zaken berichten")
    val anpIdentificatie: Long?,

    @field:Schema(description = "Gemeente waarvan persoon een inwoner is", maxLength = 10)
    val gemeentecode: String?,

    @field:Schema(description = "Geboorteland")
    val geboorteland: Land?,

    @field:Schema(description = "Overlijdensland")
    val overlijdensland: Land?,

    @field:Schema(description = "Burgerlijke staat")
    val burgerlijkeStaat: BurgerlijkeStaat,

    @field:Schema(description = "Nationaliteiten")
    val nationaliteiten: List<Nationaliteit>?,

    @field:Schema(description = "Reisdocumenten")
    val reisdocumenten: List<Reisdocument>?,

    @field:Schema(description = "Relaties met andere personen")
    val relaties: List<Relatie>?,

    ) : Subject(
    identifier = identifier,
    subjecttype = Subjecttype.persoon,
    notities = notities,
    telefoonnummer = telefoonnummer,
    telefoonnummerAlternatief = telefoonnummerAlternatief,
    emailadres = emailadres,
    rekeningnummer = rekeningnummer,
    ontvangenZaakNotificaties = ontvangenZaakNotificaties,
    toestemmingZaakNotificatiesAlleenDigitaal = toestemmingZaakNotificatiesAlleenDigitaal,
    handmatigToegevoegd = handmatigToegevoegd,
    adressen = adressen
)
