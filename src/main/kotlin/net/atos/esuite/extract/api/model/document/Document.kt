package net.atos.esuite.extract.api.model.document

import net.atos.esuite.extract.api.model.taak.Taak
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate
import java.time.ZonedDateTime

class Document(
    @field:Schema(description = "Functionele identificatie van document", maxLength = 36)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Vorm van document", required = false)
    val documentVorm: DocumentVorm?,

    @field:Schema(description = "Type document")
    val documenttype: Documenttype,

    @field:Schema(description = "Status van document")
    val documentstatus: Documentstatus,

    @field:Schema(description = "Titel van document", maxLength = 255)
    val titel: String,

    @field:Schema(description = "Kenmerk van document", maxLength = 128, required = false)
    val kenmerk: String?,

    @field:Schema(description = "Tijdstip waarop document is aangemaakt", implementation = ZonedDateTime::class)
    val creatieDatumTijd: ZonedDateTime,

    @field:Schema(
        description = "Meest recente tijdstip waarop document is gewijzigd",
        implementation = ZonedDateTime::class,
        required = false
    )
    val wijzigDatumTijd: ZonedDateTime?,

    @field:Schema(description = "Document publicatieniveau")
    val publicatieniveau: DocumentPublicatieniveau,

    @field:Schema(description = "Document verstuur gegevens", required = false)
    val documentVersturen: DocumentVersturen?,

    @field:Schema(description = "Datum van versturen document via mail", implementation = LocalDate::class, required = false)
    val documentVersturenDatum: LocalDate?,

    @field:Schema(description = "Is dit document een aanvraag document")
    val aanvraagDocument: Boolean,

    @field:Schema(description = "Datum ontvangst document", implementation = LocalDate::class, required = false)
    val ontvangstDatum: LocalDate?,

    @field:Schema(description = "Datum verzenden document", implementation = LocalDate::class, required = false)
    val verzendDatum: LocalDate?,

    @field:Schema(description = "Document richting")
    val documentrichting: DocumentRichting,

    @field:Schema(description = "Locatie van document", maxLength = 128, required = false)
    val locatie: String?,

    @field:Schema(description = "Toelichting, trefwoorden etc", required = false)
    val beschrijving: String?,

    @field:Schema(description = "Gebruikersnaam van medewerker die document heeft gelocked", maxLength = 64, required = false)
    val lockEigenaarId: String?,

    @field:Schema(description = "Datum en tijd van locken van document", implementation = ZonedDateTime::class, required = false)
    val lockDatumTijd: ZonedDateTime?,

    @field:Schema(description = "Versies van document")
    val documentversies: List<Documentversie>,

    @field:Schema(description = "Document metadata", required = false)
    val documentMetadata: List<DocumentMetadata>?,

    @field:Schema(description = "Taak waaraan document is gerelateerd", required = false)
    val taak: Taak?,

    @field:Schema(description = "Document historie")
    val historie: List<Documenthistorie>,

    @field:Schema(description = "Document publicaties", required = false)
    val publicaties: List<DocumentPublicatie>?,

    @field:Schema(description = "ID van document inhoud van PDFA versie van document", required = false)
    val pdfaDocumentInhoudID: Long?,

    @field:Schema(description = "Document versie van PDFA versie van document", required = false)
    val pdfaDocumentversie: Documentversie?,

    @field:Schema(description = "Taal van document", required = false)
    val taal: Taal?,

    @field:Schema(description = "Gebruikersnamen van medewerkers welke zijn geautoriseerd voor document", required = false)
    val geautoriseerdeMedewerkers: Set<String>?,

    @field:Schema(description = "Betreft dit een document met specifieke medewerker autorisatie")
    val geautoriseerdVoorMedewerkers: Boolean,

    @field:Schema(description = "Indicatie of het document omgezet moet worden naar pdfa")
    val converterenNaarPdfa: Boolean,
) {
    val locked: Boolean
        @Schema(description = "Is document gelocked", required = true)
        get() = lockEigenaarId != null
}
