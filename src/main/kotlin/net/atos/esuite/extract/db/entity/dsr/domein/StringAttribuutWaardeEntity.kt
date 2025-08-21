package net.atos.esuite.extract.db.entity.dsr.domein

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Implementatie van AbstractAttribuutWaardeEntity voor een memo waarde.
 * Dit is een String van beperkte lengte.
*/

@Entity
@DiscriminatorValue("STRING")
class StringAttribuutWaardeEntity : AbstractAttribuutWaardeEntity() {

    @Column(name = "tekstwaarde")
    lateinit var waarde: String
}
