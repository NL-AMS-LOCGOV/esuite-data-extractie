package net.atos.esuite.extract.db.entity.basisgegevens

import jakarta.persistence.*
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

@Table(name = "gm_ref_rechtsvorm", schema = "basisgegevens")
@Entity
class RechtsvormEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_rechtsvorm", length = 2, columnDefinition = "bpchar")
    lateinit var code: String

    @Column(name = "naam_nhr", unique = true, length = 128)
    var naamNhr: String? = null

    @OneToMany(mappedBy = "rechtsvorm")
    lateinit var bedrijven: MutableList<BedrijfEntity>
}
