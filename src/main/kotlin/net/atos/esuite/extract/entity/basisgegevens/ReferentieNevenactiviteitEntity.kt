package net.atos.esuite.extract.entity.basisgegevens

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "gm_ref_nevenactiviteit", schema = "basisgegevens")
class ReferentieNevenactiviteitEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_nevenactiviteit")
    var identifier: Long = 0

    @Column(name = "code", length = 7)
    var code: String? = null
}
