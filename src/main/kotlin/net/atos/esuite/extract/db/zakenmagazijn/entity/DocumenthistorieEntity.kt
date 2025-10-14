package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.*
import net.atos.esuite.extract.db.shared.AbstractHistoryEntity


// Historische gegevens van bepaalde wijzigigen in documenten
@Entity
@Table(name = "zkn_documenthistorie", schema = "zakenmagazijn")
class DocumenthistorieEntity: AbstractHistoryEntity() {

    @Id
    @Column(name = "id_documenthistorie")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_document", referencedColumnName = "id_document")
    lateinit var document: DocumentEntity

    // Naam type wijziging
    @Column(name = "typewijziging", length = 64)
    var typeWijziging: String? = null
}
