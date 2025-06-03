package net.atos.esuite.extract.entity.dsr.tabel

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.time.Instant
import java.util.*

/**
 * Implementatie van AbstractReferentietabelRecordExtraAttribuutEntity voor datums met tijd.
 */

@Entity
@DiscriminatorValue("DATUM_MET_TIJDSTIP")
class DatumTijdReferentietabelRecordExtraAttribuutEntity : AbstractReferentietabelRecordExtraAttribuutEntity() {

    @Column(name = "datum_waarde")
    lateinit var waarde: Instant
}
