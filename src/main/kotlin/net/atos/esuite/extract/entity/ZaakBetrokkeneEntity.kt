package net.atos.esuite.extract.entity

import jakarta.persistence.*


@Entity
@Table(name = "zkn_zaak_betrokkene", schema = "zakenmagazijn")
class ZaakBetrokkeneEntity {

    @Id
    @Column(name = "id_zaak_betrokkene")
    lateinit var identifier: java.lang.Long

}
