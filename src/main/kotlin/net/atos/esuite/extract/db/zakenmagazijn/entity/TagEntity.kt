package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_document_tag", schema = "zakenmagazijn")
class TagEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_document_tag")
    var identifier: Long = 0
}
