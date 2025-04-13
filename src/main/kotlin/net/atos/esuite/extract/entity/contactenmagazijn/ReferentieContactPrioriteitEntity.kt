package net.atos.esuite.extract.entity.contactenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieLongIdEntity

@Entity
@Table(name = "con_ref_contactprioriteit", schema = "contactenmagazijn")
class ReferentieContactPrioriteitEntity: AbstractReferentieLongIdEntity() {

    @Id
    @Column(name = "id_contactprioriteit")
    var identifier: Long = 0

    @Column(name = "dagen")
    var dagen: Int = 0
}
