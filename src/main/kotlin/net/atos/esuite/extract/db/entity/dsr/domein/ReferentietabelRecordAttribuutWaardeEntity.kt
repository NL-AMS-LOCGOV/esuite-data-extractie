package net.atos.esuite.extract.db.entity.dsr.domein

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import net.atos.esuite.extract.db.entity.dsr.tabel.ReferentietabelRecordEntity

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
