package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_taal", schema = "zakenmagazijn")
class ReferentieTaalEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_taal")
    var identifier: Long = 0

    @Column(name = "id_functioneel", unique = true, length = 3)
    lateinit var functioneelId: String
}
