package net.atos.esuite.extract.db.entity.dsr.tabel

import jakarta.persistence.*
import net.atos.esuite.extract.db.entity.dsr.definitie.ReferentietabelAttribuutDefinitieEntity

/**
 * Entity class voor één attribuut van een referentietabel-waarde.
 */

@Entity
@Table(name = "dsr_referentietabel_record_attribuut", schema = "dsr")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", length = 32)
abstract class AbstractReferentietabelRecordExtraAttribuutEntity {

    @Id
    @Column(name = "id_referentietabel_record_attribuut")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_referentietabel_record", referencedColumnName = "id_referentietabel_record")
    lateinit var referentietabelRecord: ReferentietabelRecordEntity

    @ManyToOne
    @JoinColumn(name = "id_def_referentietabel_attribuut", referencedColumnName = "id_def_referentietabel_attribuut")
    lateinit var referentietabelAttribuutDefinitie: ReferentietabelAttribuutDefinitieEntity
}
