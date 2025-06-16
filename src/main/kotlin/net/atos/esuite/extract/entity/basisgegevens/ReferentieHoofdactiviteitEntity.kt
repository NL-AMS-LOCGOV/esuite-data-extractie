package net.atos.esuite.extract.entity.basisgegevens

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieEntity

@Table(name = "gm_ref_hoofdactiviteit", schema = "basisgegevens")
@Entity
class ReferentieHoofdactiviteitEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_hoofdactiviteit")
    var identifier: Long = 0

    @Column(name = "code", length = 7)
    lateinit var code: String

    @OneToMany(mappedBy = "hoofdactiviteit")
    var bedrijven: MutableList<BedrijfEntity> = mutableListOf()
}
