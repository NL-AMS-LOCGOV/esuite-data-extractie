package net.atos.esuite.extract.db.entity.basisgegevens

import jakarta.persistence.*
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

@Table(name = "gm_ref_hoofdactiviteit", schema = "basisgegevens")
@Entity
class ReferentieHoofdactiviteitEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_hoofdactiviteit")
    var identifier: Long = 0

    @Column(name = "code", length = 7)
    lateinit var code: String

    @OneToMany(mappedBy = "hoofdactiviteit")
    lateinit var bedrijven: MutableList<BedrijfEntity>
}
