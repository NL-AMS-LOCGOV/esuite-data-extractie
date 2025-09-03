package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.*

@Entity
@Table(name = "ztc_zaaktype_resultaat", schema = "zakenmagazijn")
class ZaakTypeZaakResultaatEntity {

    @Id
    @Column(name = "id_zaaktype_resultaat")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_zaaktype", referencedColumnName = "id_zaaktype")
    lateinit var zaakType: ReferentieZaakTypeEntity

    @ManyToOne
    @JoinColumn(name = "id_resultaat", referencedColumnName = "id_resultaat")
    lateinit var resultaat: ReferentieResultaatEntity

    @ManyToOne
    @JoinColumn(name = "id_selectielijstitem")
    lateinit var selectielijstitem: ReferentieSelectielijstitemEntity

    // Waardering (B of V)
    @Column(name = "waardering", length = 20)
    var waardering: String? = null

    // Bewaartermijn in maanden
    @Column(name = "bewaartermijn_in_maanden")
    var bewaarTermijnInMaanden: Int? = null

    // Getoonde bewaartermijn (M of J)
    @Column(name = "toonbare_bewaartermijn_eenheid", length = 20)
    var toonbareBewaartermijnEenheid: String? = null
}
