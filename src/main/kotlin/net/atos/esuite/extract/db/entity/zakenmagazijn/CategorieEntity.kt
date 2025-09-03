package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_categorie", schema = "zakenmagazijn")
class CategorieEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_categorie")
    var identifier: Long = 0
}
