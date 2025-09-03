package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.*
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_taakdocument", schema = "zakenmagazijn")
class ReferentieTaakDocumentEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_taakdocument")
    var identifier: Long = 0

    @Column(name = "document_naam", length = 255)
    var documentNaam: String? = null

    @Column(name = "document_template", length = 255)
    var documentTemplate: String? = null

    @Column(name = "template_groep", length = 255)
    var templateGroep: String? = null

    @ManyToOne
    @JoinColumn(name = "id_documenttype")
    var documentType: ReferentieDocumentTypeEntity? = null

    @ManyToMany(mappedBy = "taakDocumenten", fetch = FetchType.LAZY)
    lateinit var taakDocumentGroepen: MutableSet<ReferentieTaakDocumentGroepEntity>
}
