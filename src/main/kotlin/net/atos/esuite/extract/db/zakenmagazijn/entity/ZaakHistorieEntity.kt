package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.*
import net.atos.esuite.extract.db.shared.AbstractHistoryEntity


@Entity
@Table(name = "zkn_zaakhistorie", schema = "zakenmagazijn")
class ZaakHistorieEntity: AbstractHistoryEntity() {

    @Id
    @Column(name = "id_zaakhistorie")
    var identifier: Long = 0

    // Naam type wijziging
    @Column(name = "typewijziging", length = 64)
    lateinit var typeWijziging: String

    // De externe nieuwe waarde van het type
    @Column(name = "ext_nieuwewaarde", length = Int.MAX_VALUE)
    var nieuweWaardeExtern: String? = null

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity
}
