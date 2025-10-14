package net.atos.esuite.extract.db.dsr.entity.domein

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Implementatie van AbstractAttribuutWaardeEntity voor een boolean waarde.
*/

@Entity
@DiscriminatorValue("BOOLEAN")
class BooleanAttribuutWaardeEntity : AbstractAttribuutWaardeEntity() {

    @Column(name = "booleanwaarde")
    var waarde: Boolean = false
}
