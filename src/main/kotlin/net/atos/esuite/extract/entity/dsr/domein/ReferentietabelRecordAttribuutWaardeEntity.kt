package net.atos.esuite.extract.entity.dsr.domein

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import net.atos.esuite.extract.entity.dsr.tabel.ReferentietabelRecordEntity
import java.math.BigDecimal
import java.time.Instant
import java.time.LocalDate

/**
 * Implementatie van AbstractAttribuutWaardeEntity voor een referentiewaarde.
 * Dit is een referentie naar een ReferentietabelRecordEntity.
*/

@Entity
@DiscriminatorValue("REFERENTIETABEL")
class ReferentietabelRecordAttribuutWaardeEntity : AbstractAttribuutWaardeEntity() {

    @ManyToOne
    @JoinColumn(name = "id_referentietabel_record", referencedColumnName = "id_referentietabel_record")
    lateinit var referentietabelRecord: ReferentietabelRecordEntity
}
