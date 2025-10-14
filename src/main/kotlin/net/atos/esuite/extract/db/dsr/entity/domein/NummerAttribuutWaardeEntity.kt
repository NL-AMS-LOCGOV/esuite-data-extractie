package net.atos.esuite.extract.db.dsr.entity.domein

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.math.BigInteger

/**
 * Implementatie van AbstractAttribuutWaardeEntity voor een integer waarde.
*/

@Entity
@DiscriminatorValue("NUMMER")
class NummerAttribuutWaardeEntity : AbstractAttribuutWaardeEntity() {

    @Column(name = "nummerwaarde", length = 19)
    lateinit var waarde: BigInteger
}
