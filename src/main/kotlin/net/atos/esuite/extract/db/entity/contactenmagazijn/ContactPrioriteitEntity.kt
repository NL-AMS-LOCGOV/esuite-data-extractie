package net.atos.esuite.extract.db.entity.contactenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "con_ref_contactprioriteit", schema = "contactenmagazijn")
class ContactPrioriteitEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_contactprioriteit")
    var identifier: Long = 0

    @Column(name = "dagen")
    var dagen: Int = 0
}
