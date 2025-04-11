package net.atos.esuite.extract.entity

import jakarta.persistence.*
import org.hibernate.annotations.Comment


// Koppeltabel tussen zaken en contacten
@Entity
@Table(name = "zkn_zaak_contact", schema = "zakenmagazijn")
class ZaakContactEntity {

    @Id
    @Column(name = "id_zaak_contact")
    lateinit var identifier: java.lang.Long

    @Column(name = "id_contact")
    lateinit var contactId: java.lang.Long

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity

}
