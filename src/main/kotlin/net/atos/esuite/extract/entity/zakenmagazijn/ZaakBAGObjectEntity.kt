package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.*

// Koppeltabel tussen zaken en BAG objecten
@Entity
@Table(name = "zkn_zaak_object", schema = "zakenmagazijn")
class ZaakBAGObjectEntity {

    @Id
    @Column(name = "id_zaak_object")
    var identifier: Long = 0

    @Column(name = "id_object", length = 128)
    lateinit var bagObjectId: String

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity
}
