package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.*

@Entity
@Table(name = "ztc_ref_zaaktype_authenticatie", schema = "zakenmagazijn")
class ZaakTypeAuthenticatieEntity {

    @Id
    @Column(name = "id_authenticatie")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_zaaktype", referencedColumnName = "id_zaaktype")
    lateinit var zaakType: ZaakTypeEntity

    @Column(name = "doelgroep", length = 20)
    @Enumerated(EnumType.STRING)
    lateinit var doelgroep: ZaakTypeDoelgroepEnum

    // One of: 'NONE', 'DIG1', 'DIG2', 'DIG3', 'DIG4', 'EHE1', 'EHE2', 'EHE3', 'EHE4', 'EHE5'
    @Column(name = "authenticatieniveau", length = 4)
    lateinit var authenticatieNiveau: String
}
