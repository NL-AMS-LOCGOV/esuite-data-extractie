package net.atos.esuite.extract.entity

import jakarta.persistence.*


@Entity
@Table(name = "zkn_zaak_notities", schema = "zakenmagazijn")
class ZaakNotitieEntity {

    @Id
    @Column(name = "id_zaak_notitie")
    lateinit var identifier: java.lang.Long

}
