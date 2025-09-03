package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_iv3categorie", schema = "zakenmagazijn")
class ReferentieIv3CategorieEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_iv3categorie")
    var identifier: Long = 0

    @Column(name = "externe_code", length = 64)
    private var externeCode: String? = null
}
