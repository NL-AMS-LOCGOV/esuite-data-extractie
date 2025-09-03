package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_besluitcategorie", schema = "zakenmagazijn")
class BesluitcategorieEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_besluitcategorie")
    var identifier: Long = 0
}
