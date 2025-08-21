package net.atos.esuite.extract.db.entity.contactenmagazijn

import jakarta.persistence.*
import net.atos.esuite.extract.db.entity.shared.AbstractHistoryEntity


@Entity
@Table(name = "con_contacthistorie", schema = "contactenmagazijn")
class ContactHistorieEntity: AbstractHistoryEntity() {

    @Id
    @Column(name = "id_contacthistorie")
    var identifier: Long = 0

    @Column(name = "typewijziging", length = 64)
    var typeWijziging: String? = null

    @ManyToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact")
    lateinit var contact: ContactEntity
}
