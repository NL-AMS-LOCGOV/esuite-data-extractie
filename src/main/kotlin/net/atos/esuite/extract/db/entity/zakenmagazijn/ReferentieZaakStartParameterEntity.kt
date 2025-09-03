package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.*

@Entity
@Table(name = "ztc_ref_zaakstartparameter", schema = "zakenmagazijn")
class ReferentieZaakStartParameterEntity {

    @Id
    @Column(name = "id_zaakstartparameter")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_zaaktype")
    lateinit var zaakType: ReferentieZaakTypeEntity

    @Column(name = "naam", length = 255)
    lateinit var naam: String

    @Column(name = "type", length = 255)
    lateinit var type: String
}
