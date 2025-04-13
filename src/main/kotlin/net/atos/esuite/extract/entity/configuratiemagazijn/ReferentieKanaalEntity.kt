package net.atos.esuite.extract.entity.configuratiemagazijn

import jakarta.persistence.*
import net.atos.esuite.extract.entity.shared.AbstractReferentieLongIdEntity


@Entity
@Table(name = "conf_ref_kanaal", schema = "configuratiemagazijn")
class ReferentieKanaalEntity : AbstractReferentieLongIdEntity() {

    @Id
    @Column(name = "id_kanaal")
    var identifier: Long = 0
}
