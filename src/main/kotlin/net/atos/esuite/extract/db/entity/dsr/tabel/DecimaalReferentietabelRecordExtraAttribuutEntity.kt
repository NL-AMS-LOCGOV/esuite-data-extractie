package net.atos.esuite.extract.db.entity.dsr.tabel

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.math.BigDecimal

/**
 * Implementatie van AbstractReferentietabelRecordExtraAttribuutEntity voor decimale getallen.
 */

@Entity
@DiscriminatorValue("DECIMAAL")
class DecimaalReferentietabelRecordExtraAttribuutEntity : AbstractReferentietabelRecordExtraAttribuutEntity() {

    @Column(name = "decimaal_waarde", length = 40, precision = 10)
    lateinit var waarde: BigDecimal
}
