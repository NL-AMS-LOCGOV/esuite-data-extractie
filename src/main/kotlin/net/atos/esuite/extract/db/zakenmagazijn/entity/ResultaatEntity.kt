package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_resultaat", schema = "zakenmagazijn")
class ResultaatEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_resultaat")
    var identifier: Long = 0

    // uitwisselingscode voor STUF
    @Column(name = "uitwisselingscode")
    lateinit var uitwisselingsCode: String
}
