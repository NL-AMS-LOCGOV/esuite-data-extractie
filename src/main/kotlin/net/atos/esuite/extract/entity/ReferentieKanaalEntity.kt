package net.atos.esuite.extract.entity

import jakarta.persistence.*


@Entity
@Table(schema = "configuratiemagazijn", name = "conf_ref_kanaal")
class ReferentieKanaalEntity : AbstractReferentieLongIdEntity() {

    @Id
    @Column(name = "id_kanaal")
    lateinit var identifier: java.lang.Long
}
