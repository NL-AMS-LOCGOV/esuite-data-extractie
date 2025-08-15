package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
sealed class AbstractComplexDataElementEntity: AbstractDataElementEntity() {

    @Column(name = "complexe_waarde", length = Int.MAX_VALUE)
    var complexeWaarde: String? = null

}
