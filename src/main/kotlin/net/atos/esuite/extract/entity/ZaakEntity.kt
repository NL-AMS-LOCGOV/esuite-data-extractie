package net.atos.esuite.extract.entity

import jakarta.persistence.*

@Entity
@Table(schema = "zakenmagazijn", name = "zkn_zaak")
class ZaakEntity {

    @Id
    @Column(name = "id_zaak")
    val identifier: Long = 0

    @Column(name = "id_functioneel")
    lateinit var functioneelId: String

    @Column(name = "id_zaaktype")
    lateinit var zaaktypeId: String
}
