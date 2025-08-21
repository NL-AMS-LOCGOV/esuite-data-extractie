package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.*
import java.sql.Blob


@Entity
@Table(name = "zkn_documentinhoud", schema = "zakenmagazijn")
class DocumentInhoudEntity {

    @Id
    @Column(name = "id_documentinhoud")
    var identifier: Long = 0

    // Indicatie of document gecomprimeerd is opgeslagen.
    @Column(name = "compressed")
    var compressed = false

    // Grootte van document in bytes
    @Column(name = "documentgrootte")
     var documentgrootte: Long = 0

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "inhoud")
    @Lob
    var inhoud: Blob? = null
}
