package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("OPTIE")
class OptieDataElementEntity: net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractComplexDataElementEntity() {
}
