package net.atos.esuite.extract.db.entity.zakenmagazijn.dataelement

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("BOOLEAN")
class BooleanDataElementEntity: AbstractDataElementEntity() {

    @Column(name = "boolean_waarde")
    var waarde: Boolean? = null
}
