package net.atos.esuite.extract.db.entity.configuratiemagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity


@Entity
@Table(name = "conf_ref_kanaal", schema = "configuratiemagazijn")
class ReferentieKanaalEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_kanaal")
    var identifier: Long = 0
}
