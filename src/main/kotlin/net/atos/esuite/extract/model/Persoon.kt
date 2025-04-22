package net.atos.esuite.extract.model

import jakarta.persistence.Column
import org.eclipse.microprofile.openapi.annotations.media.Schema

class Persoon(
    notities: List<SubjectNotitie>?,
    telefoonnummer: String?,
    telefoonnummerAlternatief: String?,
    emailadres: String?,
    rekeningnummer: String?,

    @field:Schema(description = "Burgerservicenummer (BSN)", minLength = 9, maxLength = 9)
    val burgerServiceNummer: String?,

    @field:Schema(description = "Voornamen", maxLength = 200)
    val voornamen: String?,

    @field:Schema(description = "Voorletters", maxLength = 20)
    val voorletters: String?,

    @field:Schema(description = "Naam", maxLength = 200)
    val geslachtsNaam: String?,

    @field:Schema(description = "Voorvoegsel geslachtsnaam", maxLength = 10)
    val voorvoegsel: String?,

    ) : Subject(
    subjecttype = Subjecttype.persoon,
    notities = notities,
    telefoonnummer = telefoonnummer,
    telefoonnummerAlternatief = telefoonnummerAlternatief,
    emailadres = emailadres,
    rekeningnummer = rekeningnummer,
)
