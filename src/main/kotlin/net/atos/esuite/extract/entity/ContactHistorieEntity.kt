package net.atos.esuite.extract.entity

import jakarta.persistence.*


@Entity
@Table(name = "con_contacthistorie", schema = "contactenmagazijn")
class ContactHistorieEntity: AbstractHistoryEntity() {

    @Id
    @Column(name = "id_contacthistorie")
    lateinit var identifier: java.lang.Long

    @Column(name = "typewijziging", length = 64)
    var typeWijziging: String? = null

    @ManyToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact")
    lateinit var contact: ContactEntity
}
