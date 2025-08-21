package net.atos.esuite.extract.db.entity.dsr.definitie

import jakarta.persistence.*
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

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
    lateinit var attribuutDefinities: MutableList<ReferentietabelAttribuutDefinitieEntity>
}
