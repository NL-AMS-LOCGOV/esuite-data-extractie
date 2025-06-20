package net.atos.esuite.extract.model.basisgegevens

import org.eclipse.microprofile.openapi.annotations.media.Schema

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

    @field:Schema(description = "Kamer van koophandel (KvK) nummer", minLength = 8, maxLength = 8)
    val kvkNummer: String?,

    @field:Schema(description = "Vestigingsnummer", minLength = 12, maxLength = 12)
    val vestigingsnummer: String?,

    @field:Schema(description = "Buitenlands handelsregisternummer", maxLength = 255)
    val buitenlandsHandelsregisternummer: String?,

    @field:Schema(description = "Bedrijfsnaam", maxLength = 128)
    val bedrijfsnaam: String?

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
)
