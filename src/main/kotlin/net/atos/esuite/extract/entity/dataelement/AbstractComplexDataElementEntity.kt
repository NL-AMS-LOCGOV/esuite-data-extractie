package net.atos.esuite.extract.entity.dataelement

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractComplexDataElementEntity: AbstractDataElementEntity() {

    @Column(name = "complexe_waarde", length = Int.MAX_VALUE)
    var complexeWaarde: String? = null

}
