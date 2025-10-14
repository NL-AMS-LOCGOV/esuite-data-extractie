package net.atos.esuite.extract.db.dsr.entity.tabel

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Implementatie van AbstractReferentietabelRecordExtraAttribuutEntity voor nummers / aantallen.
 */

@Entity
@DiscriminatorValue("NUMMER")
class NummerReferentietabelRecordExtraAttribuutEntity : AbstractReferentietabelRecordExtraAttribuutEntity() {

    @Column(name = "nummer_waarde")
    var waarde: Long = 0
}
