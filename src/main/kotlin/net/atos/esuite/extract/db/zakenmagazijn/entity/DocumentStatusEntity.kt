package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_documentstatus", schema = "zakenmagazijn")
class DocumentStatusEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_documentstatus")
    var identifier: Long = 0
}
