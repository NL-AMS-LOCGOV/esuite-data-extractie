package net.atos.esuite.extract.entity

import jakarta.persistence.*


@Entity
@Table(name = "zkn_zaakhistorie", schema = "zakenmagazijn")
class ZaakHistorieEntity {

    @Id
    @Column(name = "id_zaakhistorie")
    lateinit var identifier: java.lang.Long

}
