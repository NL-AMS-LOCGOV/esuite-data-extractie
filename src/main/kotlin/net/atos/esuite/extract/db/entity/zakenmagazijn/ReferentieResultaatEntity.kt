package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_resultaat", schema = "zakenmagazijn")
class ReferentieResultaatEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_resultaat")
    var identifier: Long = 0

    // uitwisselingscode voor STUF
    @Column(name = "uitwisselingscode")
    lateinit var uitwisselingsCode: String
}
