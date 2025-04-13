package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractComplexDataElementEntity: net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractDataElementEntity() {

    @Column(name = "complexe_waarde", length = Int.MAX_VALUE)
    var complexeWaarde: String? = null

}
