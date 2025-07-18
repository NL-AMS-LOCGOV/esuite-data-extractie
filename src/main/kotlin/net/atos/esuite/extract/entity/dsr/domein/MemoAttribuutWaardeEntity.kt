package net.atos.esuite.extract.entity.dsr.domein

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.math.BigDecimal
import java.time.Instant
import java.time.LocalDate

/**
 * Implementatie van AbstractAttribuutWaardeEntity voor een memo waarde.
 * Dit is een String van onbeperkte lengte.
*/

@Entity
@DiscriminatorValue("MEMO")
class MemoAttribuutWaardeEntity : AbstractAttribuutWaardeEntity() {

    @Column(name = "tekstwaarde")
    lateinit var waarde: String
}
