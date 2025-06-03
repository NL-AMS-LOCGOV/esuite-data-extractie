package net.atos.esuite.extract.entity.dsr.definitie

import jakarta.persistence.*

/**
 * Entity class voor definitie van een abstract domein object attribuut.
 * Er zijn subclasses voor de verschillende types attribuut,
 * maar in de database bevindt alles zich in één tabel (Single table inheritance).
*/

@Entity
@Table(name = "dsr_def_domein_object_attribuut", schema = "dsr")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
abstract class AbstractAttribuutDefinitieEntity {

    @Id
    @Column(name = "id_def_domein_object_attribuut")
    var identifier: Long = 0

    @Column(name = "volgnummer")
    var volgnummer: Int = 0

    @Column(name = "naam", length = 128)
    lateinit var naam: String

    @Column(name = "omschrijving")
    var omschrijving: String? = null

    // (EEN, NUL_OF_EEN, NUL_OF_MEER, EEN_OF_MEER)
    @Column(name = "cardinaliteit", length = 16)
    lateinit var cardinaliteit: String

    @Column(name = "geindexeerd")
    var geindexeerd = false

    @Column(name = "tonen_in_overzicht")
    var tonenInOverzicht = false

    @ManyToOne
    @JoinColumn(name = "id_def_domein_object", referencedColumnName = "id_def_domein_object")
    lateinit var domeinObjectDefinitie: DomeinObjectDefinitieEntity
}
