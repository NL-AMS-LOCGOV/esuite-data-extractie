package net.atos.esuite.extract.entity.dataelement

import jakarta.persistence.*
import java.math.BigDecimal



@Entity
@DiscriminatorValue("DECIMAAL")
class DecimaalDataElementEntity: AbstractDataElementEntity() {

    @Column(name = "nummer_waarde", precision = 27, scale = 10)
    var waarde: BigDecimal? = null

    // De manier waarop het nummer_waarde veld geformatteerd moet worden
    @Enumerated(EnumType.STRING)
    @Column(name = "nummer_formattering")
    var formattering: NummerFormattering? = null

}
