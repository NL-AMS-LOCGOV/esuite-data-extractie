package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.*

@Entity
@Table(name = "ztc_ref_zaakstartparameter", schema = "zakenmagazijn")
class ZaakStartParameterEntity {

    @Id
    @Column(name = "id_zaakstartparameter")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_zaaktype")
    lateinit var zaakType: ZaakTypeEntity

    @Column(name = "naam", length = 255)
    lateinit var naam: String

    @Column(name = "type", length = 255)
    lateinit var type: String
}
