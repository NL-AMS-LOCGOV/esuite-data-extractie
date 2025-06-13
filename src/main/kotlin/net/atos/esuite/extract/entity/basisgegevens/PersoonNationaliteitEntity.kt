package net.atos.esuite.extract.entity.basisgegevens

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
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
    lateinit var nationaliteit: ReferentieNationaliteitEntity
}
