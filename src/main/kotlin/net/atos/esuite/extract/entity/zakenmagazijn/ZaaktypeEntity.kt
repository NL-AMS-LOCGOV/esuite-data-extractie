package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "ztc_ref_zaaktype", schema = "zakenmagazijn")
class ZaaktypeEntity {

    @Id
    @Column(name = "id_zaaktype")
    var identifier: Long = 0

    @Column(name = "id_functioneel")
    lateinit var functioneelId: String
}
