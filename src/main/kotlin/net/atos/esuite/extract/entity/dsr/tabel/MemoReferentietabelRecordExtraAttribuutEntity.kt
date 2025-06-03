package net.atos.esuite.extract.entity.dsr.tabel

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Implementatie van AbstractStringReferentietabelRecordExtraAttribuutEntity voor een lange String.
*/

@Entity
@DiscriminatorValue("MEMO")
class MemoReferentietabelRecordExtraAttribuutEntity : AbstractStringReferentietabelRecordExtraAttribuutEntity() {
}
