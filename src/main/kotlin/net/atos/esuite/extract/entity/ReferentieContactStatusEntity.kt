package net.atos.esuite.extract.entity

import jakarta.persistence.*


@Entity
@Table(name = "con_ref_contactstatus", schema = "contactenmagazijn")
class ReferentieContactStatusEntity: AbstractReferentieLongIdEntity() {

    @Id
    @Column(name = "id_contactstatus")
    var identifier: Long = 0

    @Column(name = "status_type")
    @Enumerated(EnumType.STRING)
    var type: ContactStatusType? = null

}
