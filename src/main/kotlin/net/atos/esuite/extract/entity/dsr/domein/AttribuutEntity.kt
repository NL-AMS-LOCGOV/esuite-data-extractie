package net.atos.esuite.extract.entity.dsr.domein

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OrderBy
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.dsr.definitie.AbstractAttribuutDefinitieEntity

/**
 * Entity class voor een attribuut van een DomeinObjectEntity.
 */

@Entity
@Table(name = "dsr_attribuut", schema = "dsr")
class AttribuutEntity {

    @Id
    @Column(name = "id_attribuut")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_domein_object", referencedColumnName = "id_domein_object")
    lateinit var domeinObject: DomeinObjectEntity

    @ManyToOne
    @JoinColumn(name = "id_def_domein_object_attribuut", referencedColumnName = "id_def_domein_object_attribuut")
    lateinit var attribuutDefinitie: AbstractAttribuutDefinitieEntity

    @OneToMany(mappedBy = "attribuut")
    @OrderBy("volgnummer asc")
    val waarden: MutableList<AbstractAttribuutWaardeEntity> = mutableListOf()
}
