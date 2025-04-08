package net.atos.esuite.extract.entity

import jakarta.persistence.*


@Entity
@Table(name = "zkn_zaak_object", schema = "zakenmagazijn")
class ZaakBAGObjectEntity {

    @Id
    @Column(name = "id_zaak_object")
    lateinit var identifier: java.lang.Long

}
