package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_documenttitel", schema = "zakenmagazijn")
class DocumentTitelEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_documenttitel")
    var identifier: Long = 0
}
