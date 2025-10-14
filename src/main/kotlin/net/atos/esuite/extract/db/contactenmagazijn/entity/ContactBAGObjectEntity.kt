package net.atos.esuite.extract.db.contactenmagazijn.entity

import jakarta.persistence.*


@Entity
@Table(name = "con_contact_object", schema = "contactenmagazijn")
class ContactBAGObjectEntity {

    @Id
    @Column(name = "id_contact_object")
    var identifier: Long = 0

    @Column(name = "id_object", length = 128)
    lateinit var bagObjectId: String

    @ManyToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact")
    lateinit var contact: ContactEntity
}
