package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_handelinginitiator", schema = "zakenmagazijn")
class ReferentieHandelingInitiatorEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_handelinginitiator")
    var identifier: Long = 0
}
