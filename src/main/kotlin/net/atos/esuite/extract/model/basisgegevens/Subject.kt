package net.atos.esuite.extract.model.basisgegevens

import org.eclipse.microprofile.openapi.annotations.media.DiscriminatorMapping
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(
    oneOf = [Persoon::class, Bedrijf::class],
    discriminatorProperty = "subjecttype",
    discriminatorMapping = [
        DiscriminatorMapping("persoon", schema = Persoon::class),
        DiscriminatorMapping("bedrijf", schema = Bedrijf::class)
    ]
)
abstract class Subject(

    @field:Schema(description = "Interne identifier")
    val identifier: Long,

    @field:Schema(description = "Type subject (persoon of bedrijf")
    val subjecttype: Subjecttype,

    @field:Schema(description = "Telefoonnummer", maxLength = 20)
    val telefoonnummer: String?,

    @field:Schema(description = "Alternatief telefoonnummer", maxLength = 20)
    val telefoonnummerAlternatief: String?,

    @field:Schema(description = "Bankrekeningnummer", maxLength = 64)
    val rekeningnummer: String?,

    @field:Schema(description = "Emailadres", maxLength = 255)
    val emailadres: String?,

    @field:Schema(description = "Is het gewenst dat zaak notificaties worden ontvangen")
    val ontvangenZaakNotificaties: Boolean?,

    @field:Schema(description = "Mogen zaak notificaties alleen digitaal worden verstuurd en dus niet per post")
    val toestemmingZaakNotificatiesAlleenDigitaal: Boolean?,

    @field:Schema(description = "Indicatie handmatig toegevoegd", required = true)
    val handmatigToegevoegd: Boolean,

    @field:Schema(description = "Notities")
    val notities: List<SubjectNotitie>?,

    @field:Schema(description = "Adressen")
    val adressen: List<Adres>?,
    )

