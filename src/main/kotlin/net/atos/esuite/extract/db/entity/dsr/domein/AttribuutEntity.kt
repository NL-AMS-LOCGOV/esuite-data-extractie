package net.atos.esuite.extract.db.entity.dsr.domein

import jakarta.persistence.*
import net.atos.esuite.extract.db.entity.dsr.definitie.AbstractAttribuutDefinitieEntity

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
    lateinit var waarden: MutableList<AbstractAttribuutWaardeEntity>
}
