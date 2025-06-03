package net.atos.esuite.extract.entity.dsr.tabel

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.persistence.Temporal
import net.atos.esuite.extract.entity.dsr.definitie.ReferentietabelDefinitieEntity
import java.time.LocalDate
import java.util.*

/**
 * Entity class voor één waarde in een referentietabel.
 * Deze waarde kan meerdere attributen hebben.
 */

@Entity
@Table(name = "dsr_referentietabel_record", schema = "dsr")
class ReferentietabelRecordEntity {

    @Id
    @Column(name = "id_referentietabel_record")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_def_referentietabel", referencedColumnName = "id_def_referentietabel")
    lateinit var referentietabelDefinitie: ReferentietabelDefinitieEntity

    @Column(name = "naam", length = 128)
    lateinit var naam: String

    @Column(name = "omschrijving", length = 128)
    lateinit var omschrijving: String

    @Column(name = "ingangsdatum_geldigheid")
    lateinit var ingangsdatumGeldigheid: LocalDate

    @Column(name = "einddatum_geldigheid")
    var einddatumGeldigheid: LocalDate? = null

    @Column(name = "categorie", length = 64)
    var categorie: String? = null

    @OneToMany(mappedBy = "referentietabelRecord")
    var extraAttributen: MutableList<AbstractReferentietabelRecordExtraAttribuutEntity> = mutableListOf()
}
