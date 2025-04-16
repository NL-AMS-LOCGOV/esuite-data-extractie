package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieLongIdEntity

@Entity
@Table(name = "ztc_ref_documentstatus", schema = "zakenmagazijn")
class ReferentieDocumentStatusEntity  : AbstractReferentieLongIdEntity() {

    @Id
    @Column(name = "id_documentstatus")
    var identifier: Long = 0
}
