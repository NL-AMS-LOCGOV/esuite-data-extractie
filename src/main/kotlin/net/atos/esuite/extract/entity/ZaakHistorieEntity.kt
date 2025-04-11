package net.atos.esuite.extract.entity

import jakarta.persistence.*


@Entity
@Table(name = "zkn_zaakhistorie", schema = "zakenmagazijn")
class ZaakHistorieEntity: AbstractHistoryEntity() {

    @Id
    @Column(name = "id_zaakhistorie")
    lateinit var identifier: java.lang.Long

    // Naam type wijziging
    @Column(name = "typewijziging", length = 64)
    lateinit var typeWijziging: String

    // De externe nieuwe waarde van het type
    @Column(name = "ext_nieuwewaarde", length = Integer.MAX_VALUE)
    var nieuweWaardeExtern: String? = null

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity
}
