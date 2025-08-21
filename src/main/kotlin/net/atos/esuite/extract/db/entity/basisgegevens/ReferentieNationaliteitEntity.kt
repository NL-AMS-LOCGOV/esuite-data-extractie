package net.atos.esuite.extract.db.entity.basisgegevens

import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "gm_ref_nationaliteiten", schema = "basisgegevens")
@AttributeOverride(name = "gbacode", column = Column(name = "gbacode", length = 10))
class ReferentieNationaliteitEntity : AbstractGbacodeIdEntity() {
}
