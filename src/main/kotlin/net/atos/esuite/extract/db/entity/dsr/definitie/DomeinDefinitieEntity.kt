package net.atos.esuite.extract.db.entity.dsr.definitie

import jakarta.persistence.*
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

/**
 * Entity class voor een domein.
*/

@Entity
@Table(name = "dsr_def_domein", schema = "dsr")
class DomeinDefinitieEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_def_domein")
    var identifier: Long = 0

    @OneToMany(mappedBy = "domeinDefinitie")
    lateinit var domeinObjectDefinities: MutableList<DomeinObjectDefinitieEntity>
}
