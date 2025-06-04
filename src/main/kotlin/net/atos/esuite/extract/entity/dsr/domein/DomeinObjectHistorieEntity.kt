package net.atos.esuite.extract.entity.dsr.domein

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractHistoryEntity

@Entity
@Table(name = "dsr_domein_object_historie", schema = "dsr")
class DomeinObjectHistorieEntity : AbstractHistoryEntity() {

    @Id
    @Column(name = "id_domein_object_historie")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_domein_object", referencedColumnName = "id_domein_object")
    lateinit var domeinObject: DomeinObjectEntity

    // Naam gewijzigd attribuut of koppeling
    @Column(name = "typewijziging", length = 128)
    var typeWijziging: String? = null
}
