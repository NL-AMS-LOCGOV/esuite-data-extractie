package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_selectielijstitem", schema = "zakenmagazijn")
class SelectielijstitemEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_selectielijstitem")
    var identifier: Long = 0

    // Versie (jaar) van het selectielijstitem
    @Column(name = "jaar")
    var jaar: Int? = null

    // Naam van het domein
    @Column(name = "domein", length = 255)
    var domein: String? = null

    // Naam van het subdomein
    @Column(name = "subdomein", length = 255)
    var subdomein: String? = null

    // Waarding (B of V)
    @Column(name = "waardering", length = 20)
    var waardering: String? = null

    // Bewaartermijn in maanden
    @Column(name = "bewaartermijn_in_maanden")
    var bewaartermijnInMaanden: Int? = null

    // Aanduiding bewaartermijn in lijsten (MAANDEN of JAREN)
    @Column(name = "toonbare_bewaartermijn_eenheid", length = 20)
    var toonbareBewaartermijnEenheid: String? = null
}
