package net.atos.esuite.extract.db.entity.dsr.domein

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Implementatie van AbstractAttribuutWaardeEntity voor een geo onformatie waarde.
*/

@Entity
@DiscriminatorValue("GEO_INFORMATIE")
class GeoInformatieAttribuutWaardeEntity : AbstractAttribuutWaardeEntity() {

    @Column(name = "tekstwaarde")
    lateinit var waarde: String
}
