package net.atos.esuite.extract.entity.dsr.domein

import jakarta.persistence.*

/**
 * Absctacte class voor één attribuutwaarde van een AttribuutEntity.
 * Een attribuut kan meerdere waardes hebben, afhankelijk van de Cardinaliteit.
 * Er zijn subclasses voor de verschillende datatypes.
 */
@Entity
@Table(name = "dsr_attribuut_waarde", schema = "dsr")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "datatype", length = 18)
abstract class AbstractAttribuutWaardeEntity {

    @Id
    @Column(name = "id_attribuut_waarde")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_attribuut", referencedColumnName = "id_attribuut")
    lateinit var attribuut: AttribuutEntity

    // Positie van deze waarde tussen andere waarden voor attribuut
    @Column(name = "volgnummer")
    var volgnummer: Int = 0
}
