package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieLongIdEntity

@Entity
@Table(name = "ztc_ref_taal", schema = "zakenmagazijn")
class ReferentieTaalEntity : AbstractReferentieLongIdEntity() {

    @Id
    @Column(name = "id_taal")
    var identifier: Long = 0

    @Column(name = "id_functioneel", unique = true, length = 3)
    lateinit var functioneelId: String
}
