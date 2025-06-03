package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "zkn_documentinhoud", schema = "zakenmagazijn")
class DocumentInhoudEntity {

    @Id
    @Column(name = "id_documentinhoud")
    var identifier: Long = 0

    // Indicatie of document gecomprimeerd is opgeslagen.
    @Column(name = "compressed", nullable = false)
    var compressed = false

    // Grootte van document in bytes
    @Column(name = "documentgrootte", nullable = false)
     var documentgrootte: Long = 0
}
