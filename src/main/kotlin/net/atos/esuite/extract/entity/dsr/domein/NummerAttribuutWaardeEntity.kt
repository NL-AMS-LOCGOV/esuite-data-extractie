package net.atos.esuite.extract.entity.dsr.domein

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.math.BigDecimal
import java.math.BigInteger
import java.time.Instant
import java.time.LocalDate

/**
 * Implementatie van AbstractAttribuutWaardeEntity voor een integer waarde.
*/

@Entity
@DiscriminatorValue("NUMMER")
class NummerAttribuutWaardeEntity : AbstractAttribuutWaardeEntity() {

    @Column(name = "nummerwaarde", length = 19)
    lateinit var waarde: BigInteger
}
