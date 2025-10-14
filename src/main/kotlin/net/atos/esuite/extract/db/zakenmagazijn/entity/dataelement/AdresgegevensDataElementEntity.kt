package net.atos.esuite.extract.db.zakenmagazijn.entity.dataelement

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Specifiek dataelement voor een ADRESGEGEVENS
 */
@Entity
@DiscriminatorValue("ADRESGEGEVENS")
class AdresgegevensDataElementEntity: AbstractComplexDataElementEntity() {
}
