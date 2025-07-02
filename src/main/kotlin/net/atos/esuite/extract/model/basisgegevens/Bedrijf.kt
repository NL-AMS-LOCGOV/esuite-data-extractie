package net.atos.esuite.extract.model.basisgegevens

import jakarta.persistence.OneToMany
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

    @field:Schema(description = "Kamer van koophandel (KvK) nummer", minLength = 8, maxLength = 8)
    val kvkNummer: String?,

    @field:Schema(description = "Vestigingsnummer", minLength = 12, maxLength = 12)
    val vestigingsnummer: String?,

    @field:Schema(description = "Buitenlands handelsregisternummer", maxLength = 255)
    val buitenlandsHandelsregisternummer: String?,

    @field:Schema(description = "De volledige bedrijfsnaam zoals bekend bij de KvK", maxLength = 128)
    val bedrijfsnaam: String?,

    @field:Schema(description = "Vennootschapsnaam", maxLength = 255)
    val vennootschapsnaam: String?,

    @field:Schema(description = "Plaats van de statutaire zetel", maxLength = 64)
    val statutaireZetel: String?,

    @field:Schema(description = "Datum vestiging onderneming", implementation = LocalDate::class)
    val datumVestiging: LocalDate?,

    @field:Schema(description = "Datum opheffing onderneming", implementation = LocalDate::class)
    val datumOpheffing: LocalDate?,

    @field:Schema(description = "Datum voortzetting onderneming", implementation = LocalDate::class)
    val datumVoortzetting: LocalDate?,

    @field:Schema(description = "Telefaxnummer", maxLength = 20)
    val faxnummer: String?,

    @field:Schema(description = "Totaal aantal werknemers")
    val aantalWerknemers: Int?,

    @field:Schema(description = "Indicatie surseance van betaling", required = true)
    val inSurceance: Boolean,

    @field:Schema(description = "Indicatie van faillisement", required = true)
    val failliet: Boolean,

    @field:Schema(description = "RSI nummer onderneming", maxLength = 20)
    val rsinummer: String?,

    @field:Schema(description = "Status vestiging")
    val vestigingsstatus: Vestigingsstatus?,

    @field:Schema(description = "Ingangsdatum geldigheid record vanaf", implementation = LocalDate::class)
    val ingangsdatum: LocalDate,

    @field:Schema(description = "Datum waarop record voor het laatst is gewijzigd", implementation = LocalDate::class)
    val mutatiedatum: LocalDate?,

    @field:Schema(description = "Vestigingstype")
    val vestigingstype: Vestigingstype,

    @field:Schema(description = "Hoofdactiviteit")
    val hoofdactiviteit: Hoofdactiviteit?,

    @field:Schema(description = "Rechtsvorm")
    val rechtsvorm: Rechtsvorm?,

    @field:Schema(description = "Nevenactiviteiten")
    val nevenactiviteiten: Set<Nevenactiviteit>?,

    @OneToMany(mappedBy = "bedrijf")
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
