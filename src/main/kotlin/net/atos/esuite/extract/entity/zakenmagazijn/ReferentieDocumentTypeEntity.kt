package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.*
import net.atos.esuite.extract.entity.shared.AbstractReferentieEntity


@Entity
@Table(name = "ztc_ref_documenttype", schema = "zakenmagazijn")
class ReferentieDocumentTypeEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_documenttype")
    var identifier: Long = 0

    // Aanduiding documentcategorie
    @Column(name = "documentcategorie", length = 64)
    var documentcategorie: String? = null

    // Default publicatieniveau
    @Column(name = "publicatieniveau")
    @Enumerated(EnumType.STRING)
    lateinit var publicatieniveau: DocumentPublicatieniveau
}
