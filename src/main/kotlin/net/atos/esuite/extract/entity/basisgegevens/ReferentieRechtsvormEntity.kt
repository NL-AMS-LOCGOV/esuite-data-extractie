package net.atos.esuite.extract.entity.basisgegevens

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieEntity

@Table(name = "gm_ref_rechtsvorm", schema = "basisgegevens")
@Entity
class ReferentieRechtsvormEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_rechtsvorm", length = 2, columnDefinition = "bpchar")
    lateinit var code: String

    @Column(name = "naam_nhr", unique = true, length = 128)
    var naamNhr: String? = null

    @OneToMany(mappedBy = "rechtsvorm")
    var bedrijven: MutableList<BedrijfEntity> = mutableListOf()
}
