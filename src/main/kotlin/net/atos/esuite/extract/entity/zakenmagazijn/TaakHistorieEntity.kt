package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.*
import net.atos.esuite.extract.entity.shared.AbstractHistoryEntity


@Entity
@Table(name = "zkn_taakhistorie", schema = "zakenmagazijn")
class TaakHistorieEntity: AbstractHistoryEntity() {

    @Id
    @Column(name = "id_taakhistorie")
    var identifier: Long = 0

    @Column(name = "typewijziging", length = 64)
    var typeWijziging: String? = null

    @ManyToOne
    @JoinColumn(name = "id_taak", referencedColumnName = "id_taak")
    lateinit var taak: TaakEntity
}
