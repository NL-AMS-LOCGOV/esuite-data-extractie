package net.atos.esuite.extract.entity

import jakarta.persistence.*


@Entity
@Table(name = "conf_ref_kanaal", schema = "configuratiemagazijn")
class ReferentieKanaalEntity : AbstractReferentieLongIdEntity() {

    @Id
    @Column(name = "id_kanaal")
    var identifier: Long = 0
}
