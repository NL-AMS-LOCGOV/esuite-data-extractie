package net.atos.esuite.extract.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "ztc_ref_resultaat", schema = "zakenmagazijn")
class ReferentieResultaatEntity : AbstractReferentieLongIdEntity() {

    @Id
    @Column(name = "id_resultaat")
    var identifier: Long = 0

    @Column(name = "uitwisselingscode")
    lateinit var uitwisselingsCode: String
}
