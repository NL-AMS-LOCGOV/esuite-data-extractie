package net.atos.esuite.extract.db.entity.basisgegevens

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "gm_relaties", schema = "basisgegevens")
class RelatieEntity {

    @Id
    @Column(name = "id_relatie")
    var identifier: Long = 0

    @Column(name = "relatietype", length = 1)
    lateinit var relatieType: String

    @Column(name = "soortverbintenis")
    var soortVerbintenis: String? = null

    @Column(name = "datumsluitingverbintenis")
    var datumSluitingVerbintenis: LocalDate? = null

    @Column(name = "plaatssluitingverbintenis", length = 128)
    var plaatsSluitingVerbintenis: String? = null

    @ManyToOne
    @JoinColumn(name = "id_landsluitingverbintenis", referencedColumnName = "gbacode")
    var landSluitingVerbintenis: ReferentieLandEntity? = null

    @Column(name = "datumontbindingverbintenis")
    var datumOntbindingVerbintenis: LocalDate? = null

    @Column(name = "redenontbindingverbintenis", length = 1)
    var redenOntbindingVerbintenis: String? = null

    @Column(name = "plaatsontbindingverbintenis", length = 128)
    var plaatsOntbindingVerbintenis: String? = null

    @ManyToOne
    @JoinColumn(name = "id_persoon_01", referencedColumnName = "id_persoon")
    lateinit var persoon: PersoonEntity

    @ManyToOne
    @JoinColumn(name = "id_persoon_02", referencedColumnName = "id_persoon")
    lateinit var gerelateerdePersoon: PersoonEntity

    @ManyToOne
    @JoinColumn(name = "id_landontbindingverbintenis", referencedColumnName = "gbacode")
    var landOntbindingVerbintenis: ReferentieLandEntity? = null
}
