package net.atos.esuite.extract.entity

import jakarta.persistence.*

@Entity
@Table(name = "zkn_document", schema = "zakenmagazijn")
class DocumentEntity {

    @Id
    @Column(name = "id_document")
    lateinit var identifier: java.lang.Long

}
