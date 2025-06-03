package net.atos.esuite.extract.entity.dsr.tabel

import jakarta.persistence.Column
import jakarta.persistence.Entity

/**
 * Superclass voor AbstractReferentietabelRecordExtraAttribuutEntitys met een String als waarde.
 */

@Entity
abstract class AbstractStringReferentietabelRecordExtraAttribuutEntity :
    AbstractReferentietabelRecordExtraAttribuutEntity() {

    @Column(name = "tekst_waarde")
    lateinit var waarde: String
}
