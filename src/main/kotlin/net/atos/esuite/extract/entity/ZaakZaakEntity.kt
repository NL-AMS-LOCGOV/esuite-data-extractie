package net.atos.esuite.extract.entity

import jakarta.persistence.*


@Entity
@Table(name = "zkn_zaak_zaak", schema = "zakenmagazijn")
class ZaakZaakEntity {

    @Id
    @Column(name = "id_zaak_zaak")
    lateinit var identifier: java.lang.Long

}
