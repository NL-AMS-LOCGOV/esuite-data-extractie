package net.atos.esuite.extract.entity.configuratiemagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "conf_ref_organisatie", schema = "configuratiemagazijn")
class ReferentieOrganisatieEntity: AbstractReferentieEntity() {

    @Id
    @Column(name = "id_organisatie")
    var identifier: Long = 0
}
