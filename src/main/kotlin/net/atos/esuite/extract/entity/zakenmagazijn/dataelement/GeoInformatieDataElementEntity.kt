package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("GEO_INFORMATIE")
class GeoInformatieDataElementEntity: AbstractComplexDataElementEntity() {
}
