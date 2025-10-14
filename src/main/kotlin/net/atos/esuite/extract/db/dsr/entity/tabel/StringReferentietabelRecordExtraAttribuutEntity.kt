package net.atos.esuite.extract.db.dsr.entity.tabel

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Implementatie van AbstractStringReferentietabelRecordExtraAttribuutEntity voor een korte String.
*/

@Entity
@DiscriminatorValue("STRING")
class StringReferentietabelRecordExtraAttribuutEntity :AbstractStringReferentietabelRecordExtraAttribuutEntity() {
}
