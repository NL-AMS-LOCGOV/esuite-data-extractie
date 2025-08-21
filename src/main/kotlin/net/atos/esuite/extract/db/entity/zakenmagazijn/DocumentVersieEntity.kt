package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "zkn_documentversie", schema = "zakenmagazijn")
class DocumentVersieEntity {

    @Id
    @Column(name = "id_documentversie")
    var identifier: Long = 0

    @Column(name = "versienummer")
    var versienummer = 0

    // ID van het bestand dat het document bevat in het DMS.
    @Column(name = "bestandsid", length = 255)
    lateinit var bestandsId: String
    
    // Datum waarop de versie werd aangemaakt
    @Column(name = "creatiedatum")
    lateinit var creatiedatum: LocalDate

    // Naam van de auteur
    @Column(name = "auteur", length = 128)
    var auteur: String? = null

    // Naam van de afzender
    @Column(name = "afzender", length = 128)
    var afzender: String? = null

    // Bestandsnaam van het document
    @Column(name = "bestandsnaam", length = 255)
    lateinit var bestandsnaam: String

    @Column(name = "mimetype", length = 255)
    lateinit var mimetype: String

    @ManyToOne
    @JoinColumn(name = "id_document", referencedColumnName = "id_document")
    lateinit var document: DocumentEntity

    @OneToMany(mappedBy = "documentVersie")
    @OrderBy("ondertekenDatum desc")
    lateinit var ondertekeningen: MutableSet<DocumentOndertekeningEntity>

}
