package net.atos.esuite.extract.db.dsr.entity.definitie

import jakarta.persistence.*
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

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
