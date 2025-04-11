package net.atos.esuite.extract.entity.dataelement

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("GENERIEKE_AFSPRAAK")
class GeneriekeAfspraakItemDataElementEntity: AbstractComplexDataElementEntity() {
}
