package net.atos.esuite.extract.entity.dsr.tabel

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Implementatie van AbstractStringReferentietabelRecordExtraAttribuutEntity voor een korte String.
*/

@Entity
@DiscriminatorValue("STRING")
class StringReferentietabelRecordExtraAttribuutEntity :AbstractStringReferentietabelRecordExtraAttribuutEntity() {
}
