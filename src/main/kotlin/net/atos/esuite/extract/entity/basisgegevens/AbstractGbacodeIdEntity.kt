package net.atos.esuite.extract.entity.basisgegevens

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import net.atos.esuite.extract.entity.shared.AbstractReferentieEntity

@MappedSuperclass
abstract class AbstractGbacodeIdEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "gbacode")
    lateinit var gbacode: String
}
