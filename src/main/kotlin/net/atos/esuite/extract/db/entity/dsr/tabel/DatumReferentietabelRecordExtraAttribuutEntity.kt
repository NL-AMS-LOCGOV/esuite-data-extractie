package net.atos.esuite.extract.db.entity.dsr.tabel

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.time.Instant

/**
 * Implementatie van AbstractReferentietabelRecordExtraAttribuutEntity voor datums zonder tijd.
*/

@Entity
@DiscriminatorValue("DATUM")
class DatumReferentietabelRecordExtraAttribuutEntity : AbstractReferentietabelRecordExtraAttribuutEntity() {

    @Column(name = "datum_waarde")
    lateinit var waarde: Instant
}
