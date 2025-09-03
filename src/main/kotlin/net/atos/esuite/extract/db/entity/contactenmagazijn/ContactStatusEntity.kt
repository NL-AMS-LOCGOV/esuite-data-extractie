package net.atos.esuite.extract.db.entity.contactenmagazijn

import jakarta.persistence.*
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity


@Entity
@Table(name = "con_ref_contactstatus", schema = "contactenmagazijn")
class ContactStatusEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_contactstatus")
    var identifier: Long = 0

    @Column(name = "status_type")
    @Enumerated(EnumType.STRING)
    var type: ContactStatusType? = null

}
