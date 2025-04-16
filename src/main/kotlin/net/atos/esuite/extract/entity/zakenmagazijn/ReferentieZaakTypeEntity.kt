package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieLongIdEntity

@Entity
@Table(name = "ztc_ref_zaaktype", schema = "zakenmagazijn")
class ReferentieZaakTypeEntity : AbstractReferentieLongIdEntity(){

    @Id
    @Column(name = "id_zaaktype")
    var identifier: Long = 0

    @Column(name = "id_functioneel", length = 128)
    lateinit var functioneelId: String

}
