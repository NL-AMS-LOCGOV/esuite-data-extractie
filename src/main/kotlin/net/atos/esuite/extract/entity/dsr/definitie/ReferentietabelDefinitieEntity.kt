package net.atos.esuite.extract.entity.dsr.definitie

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OrderBy
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieEntity
import java.util.*

/**
 * Entity class voor de definitie van een referentietabel.
*/

@Entity
@Table(name = "dsr_def_referentietabel", schema = "dsr")
class ReferentietabelDefinitieEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_def_referentietabel")
    var identifier: Long = 0

    // Is de referentie tabel een master/detail referentie tabel
    @Column(name = "master_detail")
    var masterDetail = false

    @OneToMany(mappedBy = "referentietabel")
    @OrderBy("volgnummer ASC")
    var attribuutDefinities: MutableList<ReferentietabelAttribuutDefinitieEntity> = mutableListOf()
}
