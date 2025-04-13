package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Specifiek dataelement voor een ADRESGEGEVENS
 */
@Entity
@DiscriminatorValue("ADRESGEGEVENS")
class AdresgegevensDataElementEntity: net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractComplexDataElementEntity() {
}
