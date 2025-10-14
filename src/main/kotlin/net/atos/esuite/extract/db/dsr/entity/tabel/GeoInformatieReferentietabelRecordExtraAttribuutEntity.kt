package net.atos.esuite.extract.db.dsr.entity.tabel

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Entity die een stringwaarde heeft die een geografisch gebied representeert.
 * Het formaat van de string is "Well-known text".
*/

@Entity
@DiscriminatorValue("GEO_INFORMATIE")
class GeoInformatieReferentietabelRecordExtraAttribuutEntity : AbstractStringReferentietabelRecordExtraAttribuutEntity() {
}
