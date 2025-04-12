package net.atos.esuite.extract.entity

import jakarta.persistence.*


@Entity
@Table(name = "con_contact_object", schema = "contactenmagazijn")
class ContactBAGObjectEntity {

    @Id
    @Column(name = "id_contact_object")
    lateinit var identifier: java.lang.Long

    @Column(name = "id_object", length = 128)
    var bagObjectId: String? = null

    @ManyToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact")
    lateinit var contact: ContactEntity
}
