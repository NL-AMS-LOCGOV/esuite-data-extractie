package net.atos.esuite.extract.entity.dsr.tabel

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
