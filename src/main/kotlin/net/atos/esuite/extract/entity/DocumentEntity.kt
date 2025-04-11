package net.atos.esuite.extract.entity

import jakarta.persistence.*
import java.time.Instant
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.*


@Entity
@Table(name = "zkn_document", schema = "zakenmagazijn")
class DocumentEntity {

    @Id
    @Column(name = "id_document")
    lateinit var identifier: java.lang.Long

    @Column(name = "id_functioneel", length = 36)
    lateinit var idFunctioneel: String

    // ToDo: Create DocumentvormEntity: ID-nummer tabel Documentvorm
    @Column(name = "documentvorm_id", length = 255)
    lateinit var documentvormId: String

    // ToDo: create DocumenttypeEntity:  ID-nummer tabel Documenttype
    @Column(name = "documenttype_id", length = 255)
    lateinit var documenttypeId: String

    // ToDo: create DocumentStatusEntity ID-nummer tabel Documentstatus
    @Column(name = "documentstatus_id", length = 255)
    lateinit var documentstatusId: String

    // Titel van het document (naam)
    @Column(name = "titel", length = 256)
    lateinit var titel: String

    // Kenmerk van het document
    @Column(name = "kenmerk", length = 128)
    var kenmerk: String? = null

    // Tijdstip waarop het document is geinsert.
    @Column(name = "creatiedatumtijd")
    lateinit var creatiedatum: Instant

    // Tijdstip waarop de laatste documenthistory is geinsert.
    @Column(name = "wijzigdatumtijd")
    var wijzigdatum: Instant? = null

    // Publicatieniveau (Extern, Intern, Vertrouwelijk)
    @Column(name = "publicatieniveau", length = 16)
    @Enumerated(EnumType.STRING)
    lateinit var publicatieniveau: DocumentPublicatieniveau

    // DocumentVersturen (MOET_NIET_VERSTUURD_WORDEN, MOET_VERSTUURD_WORDEN, IS_VERSTUURD)
    @Column(name = "documentversturen", length = 32)
    @Enumerated(EnumType.STRING)
    lateinit var documentVersturen: DocumentVersturen

    // Datum van versturen document via mail
    @Column(name = "documentversturendatum")
    var documentVersturenDatum: LocalDate? = null

    @Column(name = "ind_aanvraag")
    var indAanvraag = false

    // Datum ontvangst document of datum verzenden document
    @Column(name = "ontvangstverzendcreatiedatum")
    lateinit var ontvangstverzendcreatiedatum: LocalDate

    @Column(name = "documentrichting", length = 8)
    @Enumerated(EnumType.STRING)
    lateinit var documentrichting: DocumentRichting

    // Locatie van het document
    @Column(name = "locatie", length = 128)
    var locatie: String? = null

    // Toelichting, trefwoorden etc
    @Column(name = "beschrijving", length = Int.MAX_VALUE)
    var beschrijving: String? = null

    // ToDo: Zou gemapped kunnen worden op een boolean welke aangeeft of het document is gelocked
    // ID van de medewerker die document heeft gelocked
    @Column(name = "id_lock_eigenaar", length = 64)
    var lockEigenaarId: String? = null

    // Datum en tijd van het locken van het document
    @Column(name = "lock_datumtijd")
    var lockDatumTijd: OffsetDateTime? = null

    @OneToMany(mappedBy = "document")
    @OrderBy("versienummer asc")
    var documentversies: MutableSet<DocumentVersieEntity> = mutableSetOf()

    @OneToMany(mappedBy = "document")
    var documentMetadata: MutableSet<DocumentMetadataEntity> = mutableSetOf()

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity

    @ManyToOne
    @JoinColumn(name = "id_taak", referencedColumnName = "id_taak")
    lateinit var taak: TaakEntity

    @OneToMany(mappedBy = "document")
    @OrderBy("identifier desc")
    var historie: MutableList<DocumenthistorieEntity> = mutableListOf()

    @ElementCollection
    @JoinTable(
        name = "zkn_documentpublicatie", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_document", referencedColumnName = "id_document")]
    )
    var publicaties: MutableSet<DocumentPublicatieEntity> = mutableSetOf()

    // ID van het bestand in het DMS van de PDFA versie van het document.
    @Column(name = "pdfaid", length = 255)
    var pdfaId: String? = null

    @OneToOne()
    @JoinColumn(name = "pdfaid_documentversie", referencedColumnName = "id_documentversie")
    var pdfaDocumentVersieEntity: DocumentVersieEntity? = null

    @Column(name = "id_taal", length = 10)
    var taalId: String? = null

    @ElementCollection
    @CollectionTable(name = "zkn_document_geautoriseerde_medewerker", schema = "zakenmagazijn", joinColumns = [JoinColumn(name = "id_document")])
    @Column(name = "medewerker")
    var geautoriseerdeMedewerkers: MutableSet<String>? = mutableSetOf()

    // Of autorisatie op dit element aan of uit staat
    @Column(name = "autorisatie")
    var autorisatie = false

    // Indicatie of het document omgezet moet worden naar pdfa
    @Column(name = "converteren_naar_pdfa")
    var converterenNaarPdfa = false

}
