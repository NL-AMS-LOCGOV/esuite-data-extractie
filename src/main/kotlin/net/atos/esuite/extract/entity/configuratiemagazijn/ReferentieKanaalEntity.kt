package net.atos.esuite.extract.entity.configuratiemagazijn

import jakarta.persistence.*
import net.atos.esuite.extract.entity.shared.AbstractReferentieEntity


@Entity
@Table(name = "conf_ref_kanaal", schema = "configuratiemagazijn")
class ReferentieKanaalEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_kanaal")
    var identifier: Long = 0
}
