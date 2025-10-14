package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.*
import net.atos.esuite.extract.db.contactenmagazijn.entity.ContactEntity


// Koppeltabel tussen zaken en contacten
@Entity
@Table(name = "zkn_zaak_contact", schema = "zakenmagazijn")
class ZaakContactEntity {

    @Id
    @Column(name = "id_zaak_contact")
    var identifier: Long = 0

    @OneToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact")
    lateinit var contact: ContactEntity

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity

}
