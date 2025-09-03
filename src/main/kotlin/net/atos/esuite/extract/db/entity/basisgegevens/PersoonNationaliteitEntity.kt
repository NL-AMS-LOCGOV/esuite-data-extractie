package net.atos.esuite.extract.db.entity.basisgegevens

import jakarta.persistence.*
import java.time.LocalDate

@Table(name = "gm_persoonnationaliteit", schema = "basisgegevens")
@Entity
class PersoonNationaliteitEntity {

    @Id
    @Column(name = "id_persoonnationaliteit")
    var identifier: Long = 0

    @Column(name = "redenverkrijging", length = 255)
    var redenVerkrijging: String? = null

    @Column(name = "datumverkrijging")
    var datumVerkrijging: LocalDate? = null

    @ManyToOne
    @JoinColumn(name = "id_persoon", referencedColumnName = "id_persoon")
    lateinit var persoon: PersoonEntity

    @ManyToOne
    @JoinColumn(name = "id_nationaliteit", referencedColumnName = "gbacode")
    lateinit var nationaliteit: NationaliteitEntity
}
