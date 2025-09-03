package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_documentvorm", schema = "zakenmagazijn")
class DocumentVormEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_documentvorm")
    var identifier: Long = 0
}
