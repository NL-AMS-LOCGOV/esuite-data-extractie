package net.atos.esuite.extract.entity.dsr.definitie

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieEntity

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
    var domeinObjectDefinities: MutableList<DomeinObjectDefinitieEntity> = mutableListOf()
}
