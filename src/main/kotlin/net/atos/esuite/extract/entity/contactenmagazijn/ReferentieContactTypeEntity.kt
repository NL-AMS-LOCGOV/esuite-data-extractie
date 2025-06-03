package net.atos.esuite.extract.entity.contactenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "con_ref_contacttype", schema = "contactenmagazijn")
class ReferentieContactTypeEntity: AbstractReferentieEntity() {

    @Id
    @Column(name = "id_contacttype")
    var identifier: Long = 0

}
