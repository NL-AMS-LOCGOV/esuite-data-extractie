package net.atos.esuite.extract.api.model.subject

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

@Schema(allOf = [Subject::class])
class Bedrijf(
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

    @field:Schema(description = "Kamer van koophandel (KvK) nummer", minLength = 8, maxLength = 8, required = false)
    val kvkNummer: String?,

    @field:Schema(description = "Vestigingsnummer", minLength = 12, maxLength = 12, required = false)
    val vestigingsnummer: String?,

    @field:Schema(description = "Buitenlands handelsregisternummer", maxLength = 255, required = false)
    val buitenlandsHandelsregisternummer: String?,

    @field:Schema(description = "De volledige bedrijfsnaam zoals bekend bij de KvK", maxLength = 128, required = false)
    val bedrijfsnaam: String?,

    @field:Schema(description = "Vennootschapsnaam", maxLength = 255, required = false)
    val vennootschapsnaam: String?,

    @field:Schema(description = "Plaats van de statutaire zetel", maxLength = 64, required = false)
    val statutaireZetel: String?,

    @field:Schema(description = "Datum vestiging onderneming", implementation = LocalDate::class, required = false)
    val datumVestiging: LocalDate?,

    @field:Schema(description = "Datum opheffing onderneming", implementation = LocalDate::class, required = false)
    val datumOpheffing: LocalDate?,

    @field:Schema(description = "Datum voortzetting onderneming", implementation = LocalDate::class, required = false)
    val datumVoortzetting: LocalDate?,

    @field:Schema(description = "Telefaxnummer", maxLength = 20, required = false)
    val faxnummer: String?,

    @field:Schema(description = "Totaal aantal werknemers", required = false)
    val aantalWerknemers: Int?,

    @field:Schema(description = "Indicatie surseance van betaling")
    val inSurceance: Boolean,

    @field:Schema(description = "Indicatie van faillisement")
    val failliet: Boolean,

    @field:Schema(description = "RSI nummer onderneming", maxLength = 20, required = false)
    val rsinummer: String?,

    @field:Schema(description = "Status vestiging", required = false)
    val vestigingsstatus: Vestigingsstatus?,

    @field:Schema(description = "Ingangsdatum geldigheid record vanaf", implementation = LocalDate::class)
    val ingangsdatum: LocalDate,

    @field:Schema(description = "Datum waarop record voor het laatst is gewijzigd", implementation = LocalDate::class, required = false)
    val mutatiedatum: LocalDate?,

    @field:Schema(description = "Vestigingstype")
    val vestigingstype: Vestigingstype,

    @field:Schema(description = "Hoofdactiviteit", required = false)
    val hoofdactiviteit: Hoofdactiviteit?,

    @field:Schema(description = "Rechtsvorm", required = false)
    val rechtsvorm: Rechtsvorm?,

    @field:Schema(description = "Nevenactiviteiten", required = false)
    val nevenactiviteiten: Set<Nevenactiviteit>?,

    @field:Schema(description = "Contactpersonen", required = false)
    val contactpersonen: List<Contactpersoon>?,

    ) : Subject(
    identifier = identifier,
    subjecttype = Subjecttype.bedrijf,
    notities = notities,
    telefoonnummer = telefoonnummer,
    telefoonnummerAlternatief = telefoonnummerAlternatief,
    emailadres = emailadres,
    rekeningnummer = rekeningnummer,
    ontvangenZaakNotificaties = ontvangenZaakNotificaties,
    toestemmingZaakNotificatiesAlleenDigitaal = toestemmingZaakNotificatiesAlleenDigitaal,
    handmatigToegevoegd = handmatigToegevoegd,
    adressen = adressen,
    )
