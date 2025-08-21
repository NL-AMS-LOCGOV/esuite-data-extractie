package net.atos.esuite.extract.db.entity.basisgegevens

import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Table(name = "gm_ref_reisdocumenten", schema = "basisgegevens")
@Entity
@AttributeOverride(name = "gbacode", column = Column(name = "gbacode", length = 2))
class ReferentieReisdocumentEntity : AbstractGbacodeIdEntity() {
}
