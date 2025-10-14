package net.atos.esuite.extract.db.configuratiemagazijn.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

@Entity
@Table(name = "conf_ref_organisatie", schema = "configuratiemagazijn")
class OrganisatieEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_organisatie")
    var identifier: Long = 0
}
