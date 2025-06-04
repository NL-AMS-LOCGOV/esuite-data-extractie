package net.atos.esuite.extract.entity.dsr.domein

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.math.BigDecimal
import java.time.Instant
import java.time.LocalDate

/**
 * Implementatie van AbstractAttribuutWaardeEntity voor een decimaal waarde.
*/

@Entity
@DiscriminatorValue("DECIMAAL")
class DecimaalAttribuutWaardeEntity : AbstractAttribuutWaardeEntity() {

    @Column(name = "decimaalwaarde", length = 19, precision = 9)
    lateinit var waarde: BigDecimal
}
