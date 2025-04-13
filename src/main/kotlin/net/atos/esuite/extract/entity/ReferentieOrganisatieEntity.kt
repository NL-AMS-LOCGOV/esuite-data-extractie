package net.atos.esuite.extract.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "conf_ref_organisatie", schema = "configuratiemagazijn")
class ReferentieOrganisatieEntity: AbstractReferentieLongIdEntity() {

    @Id
    @Column(name = "id_organisatie")
    var identifier: Long = 0
}
