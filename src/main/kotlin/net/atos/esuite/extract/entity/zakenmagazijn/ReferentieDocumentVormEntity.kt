package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_documentvorm", schema = "zakenmagazijn")
class ReferentieDocumentVormEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_documentvorm")
    var identifier: Long = 0
}
