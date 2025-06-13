package net.atos.esuite.extract.entity.basisgegevens

import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Table(name = "gm_ref_burgerlijkestaat", schema = "basisgegevens")
@Entity
@AttributeOverride(name = "gbacode", column = Column(name = "gbacode", length = 1))
class ReferentieBurgerlijkeStaatEntity : AbstractGbacodeIdEntity() {
}
