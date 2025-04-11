package net.atos.esuite.extract.entity.dataelement

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("STRING")
class StringDataElementEntity: AbstractDataElementEntity() {

    // De string waarde van de key, value pair, indien de waarde van type string is
    @Column(name = "string_waarde", length = Int.MAX_VALUE)
    var waarde: String? = null
}
