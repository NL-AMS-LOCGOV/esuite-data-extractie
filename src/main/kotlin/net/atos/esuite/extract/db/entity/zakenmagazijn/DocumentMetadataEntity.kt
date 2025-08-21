package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.*


@Entity
@Table(name = "zkn_document_metadata", schema = "zakenmagazijn")
class DocumentMetadataEntity {

    @Id
    @Column(name = "id_documentmetadata")
    var identifier: Long = 0

    @Column(name = "metadataelement_id", length = 255)
    var metadataelementId: String? = null

    // Waarde van het metadata element
    @Column(name = "waarde_metadata", length = Int.MAX_VALUE)
    var waardeMetadata: String? = null

    @ManyToOne
    @JoinColumn(name = "id_document", referencedColumnName = "id_document")
    lateinit var document: DocumentEntity
}
