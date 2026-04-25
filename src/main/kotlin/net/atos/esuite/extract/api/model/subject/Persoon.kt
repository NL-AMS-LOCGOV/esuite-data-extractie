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

    @field:Schema(description = "Burgerservicenummer (BSN)", minLength = 9, maxLength = 9, required = false)
    val burgerServiceNummer: String?,

    @field:Schema(description = "Voornamen", maxLength = 200, required = false)
    val voornamen: String?,

    @field:Schema(description = "Voorletters", maxLength = 20, required = false)
    val voorletters: String?,

    @field:Schema(description = "Achternaam", maxLength = 200, required = false)
    val geslachtsNaam: String?,

    @field:Schema(description = "Voorvoegsel geslachtsnaam", maxLength = 10, required = false)
    val voorvoegsel: String?,

    @field:Schema(description = "Geslachtsaanduiding", required = false)
    val geslacht: Geslacht?,

    @field:Schema(description = "Aanhef van de aanschrijving", maxLength = 64, required = false)
    val aanhefAanschrijving: String?,

    @field:Schema(description = "Adelijke titel", maxLength = 10, required = false)
    val adelijkeTitel: String?,

    @field:Schema(description = "Aanduiding pre academische titel", maxLength = 20, required = false)
    val preAcademischeTitel: String?,

    @field:Schema(description = "Aanduiding post academische titel", maxLength = 20, required = false)
    val postAcademischeTitel: String?,

    @field:Schema(description = "Aanduiding van naamgebruik", required = false)
    val naamgebruik: Naamgebruik?,

    @field:Schema(description = "Achternaam partner", maxLength = 200, required = false)
    val geslachtsNaamPartner: String?,

    @field:Schema(description = "Voorvoegsel geslachtsnaam partner", maxLength = 10, required = false)
    val voorvoegselPartner: String?,

    @field:Schema(description = "Geboortedatum", implementation = LocalDate::class, required = false)
    val geboortedatum: LocalDate? = null,

    @field:Schema(description = "Geboorteplaats", maxLength = 255, required = false)
    val geboorteplaats: String?,

    @field:Schema(description = "Overlijdensdatum", implementation = LocalDate::class, required = false)
    val overlijdensdatum: LocalDate? = null,

    @field:Schema(description = "Overlijdensplaats", maxLength = 255, required = false)
    val overlijdensplaats: String?,

    @field:Schema(name = "aNummer", description = "Gemeentelijk A-nummer", maxLength = 10, required = false)
    val anummer: String?,

    @field:Schema(description = "Reden opschorting bijhouding adresgegevens", required = false)
    val opschortingsReden: OpschortingsReden?,

    @field:Schema(description = "Datum opschorting bijhouding adresgegevens", implementation = LocalDate::class, required = false)
    val opschortingsDatum: LocalDate? = null,

    @field:Schema(description = "Indicatie blokkering tijdens verhuizing")
    val geblokkeerd: Boolean,

    @field:Schema(description = "Indicatie gezag- of curatelestelling")
    val curateleRegister: Boolean,

    @field:Schema(description = "Indicatie of er een onderzoek naar de persoon wordt uitgevoerd")
    val inOnderzoek: Boolean,

    @field:Schema(description = "Indicatie of de geboortedatum volledig is", required = false)
    val geboortedatumVolledig: OnvolledigeDatumType?,

    @field:Schema(description = "Indicatie of datum van overlijden volledig is", required = false)
    val overlijdensdatumVolledig: OnvolledigeDatumType?,

    @field:Schema(description = "Indicatie beperking verstrekking gegevens")
    val beperkingVerstrekking: Boolean,

    @field:Schema(description = "Indicatie niet-ingezetene", required = false)
    val nietIngezeteneAanduiding: NietIngezeteneAanduiding?,

    @field:Schema(description = "Indicatie of de persoon geabonneerd is op updates vanuit de makelaar")
    val afnemerIndicatie: Boolean,

    @field:Schema(description = "Ander Natuurlijk Persoon (ANP) identificatie gebruikt tijdens verwerking van StUF-zaken berichten", required = false)
    val anpIdentificatie: Long?,

    @field:Schema(description = "Gemeente waarvan persoon een inwoner is", maxLength = 10, required = false)
    val gemeentecode: String?,

    @field:Schema(description = "Geboorteland", required = false)
    val geboorteland: Land?,

    @field:Schema(description = "Overlijdensland", required = false)
    val overlijdensland: Land?,

    @field:Schema(description = "Burgerlijke staat")
    val burgerlijkeStaat: BurgerlijkeStaat,

    @field:Schema(description = "Nationaliteiten", required = false)
    val nationaliteiten: List<Nationaliteit>?,

    @field:Schema(description = "Reisdocumenten", required = false)
    val reisdocumenten: List<Reisdocument>?,

    @field:Schema(description = "Relaties met andere personen", required = false)
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
