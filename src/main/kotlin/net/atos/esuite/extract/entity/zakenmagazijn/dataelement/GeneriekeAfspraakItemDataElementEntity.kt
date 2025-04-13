package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("GENERIEKE_AFSPRAAK")
class GeneriekeAfspraakItemDataElementEntity: net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractComplexDataElementEntity() {
}
