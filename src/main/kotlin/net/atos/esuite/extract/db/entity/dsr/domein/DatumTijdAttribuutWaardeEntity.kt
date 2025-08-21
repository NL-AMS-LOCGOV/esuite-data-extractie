package net.atos.esuite.extract.db.entity.dsr.domein

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.time.Instant

/**
 * Implementatie van AbstractAttribuutWaardeEntity voor een datum/tijd waarde.
*/

@Entity
@DiscriminatorValue("DATUM_MET_TIJDSTIP")
class DatumTijdAttribuutWaardeEntity : AbstractAttribuutWaardeEntity() {

    @Column(name = "datumtijdwaarde")
    lateinit var waarde: Instant
}
