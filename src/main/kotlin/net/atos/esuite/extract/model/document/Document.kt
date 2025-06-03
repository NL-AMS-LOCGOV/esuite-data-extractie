package net.atos.esuite.extract.model.document

import net.atos.esuite.extract.model.zaak.Taak
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate
import java.time.ZonedDateTime

class Document(
    @field:Schema(description = "Functionele identificatie van document", maxLength = 36)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Vorm van document")
    val documentVorm: DocumentVorm?,

    @field:Schema(description = "type document")
    val documenttype: Documenttype,

    @field:Schema(description = "Status van document")
    val documentStatus: DocumentStatus,

    @field:Schema(description = "Titel van document", maxLength = 255)
    val titel: String,

    @field:Schema(description = "Kenmerk van document", maxLength = 128)
    val kenmerk: String?,

    @field:Schema(description = "Tijdstip waarop document is aangemaakt", implementation = ZonedDateTime::class)
    val creatieDatumTijd: ZonedDateTime,

    @field:Schema(
        description = "Meest recente tijdstip waarop document is gewijzigd",
        implementation = ZonedDateTime::class
    )
    val wijzigDatumTijd: ZonedDateTime?,

    @field:Schema(description = "Document publicatieniveau")
    val publicatieniveau: DocumentPublicatieniveau,

    @field:Schema(description = "Document verstuur gegevens")
    val documentVersturen: DocumentVersturen,

    @field:Schema(description = "Datum van versturen document via mail", implementation = LocalDate::class)
    val documentVersturenDatum: LocalDate?,

    @field:Schema(description = "Is dit document een aanvraag document", required = true)
    val aanvraagDocument: Boolean,

    @field:Schema(description = "Datum ontvangst document", implementation = LocalDate::class)
    val ontvangstDatum: LocalDate?,

    @field:Schema(description = "Datum verzenden document", implementation = LocalDate::class)
    val verzendDatum: LocalDate?,

    @field:Schema(description = "Document richting")
    val documentrichting: DocumentRichting,

    @field:Schema(description = "Locatie van document", maxLength = 128)
    val locatie: String?,

    @field:Schema(description = "Toelichting, trefwoorden etc")
    val beschrijving: String?,

    @field:Schema(description = "Gebruikersnaam van medewerker die document heeft gelocked", maxLength = 64)
    val lockEigenaarId: String?,

    @field:Schema(description = "Datum en tijd van locken van document", implementation = ZonedDateTime::class)
    val lockDatumTijd: ZonedDateTime?,

    @field:Schema(description = "Versies van document")
    val documentversies: List<Documentversie>,

    @field:Schema(description = "Document metadata")
    val documentMetadata: List<DocumentMetadata>?,

    @field:Schema(description = "Taak waaraan document is gerelateerd")
    val taak: Taak?,

    @field:Schema(description = "Document historie")
    val historie: List<Documenthistorie>,

    @field:Schema(description = "Document publicaties")
    val publicaties: List<DocumentPublicatie>?,

    @field:Schema(description = "Document versie van PDFA versie van document")
    val pdfaDocumentversie: Documentversie?,

    @field:Schema(description = "Taal van document")
    val taal: Taal?,

    @field:Schema(description = "Gebruikersnamen van medewerkers welke zijn geautoriseerd voor document")
    val geautoriseerdeMedewerkers: Set<String>?,

    @field:Schema(description = "Betreft dit een document met specifieke medewerker autorisatie", required = true)
    val geautoriseerdVoorMedewerkers: Boolean,

    @field:Schema(description = "Indicatie of het document omgezet moet worden naar pdfa", required = true)
    val converterenNaarPdfa: Boolean,
) {
    val locked: Boolean
        @Schema(description = "Is document gelocked", required = true)
        get() = lockEigenaarId != null
}
