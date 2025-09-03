package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.*

@Entity
@Table(name = "ztc_zaaktype_tag", schema = "zakenmagazijn")
class ZaakTypeTagEntity {

    @Id
    @Column(name = "id_zaaktype_tag")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_zaaktype", referencedColumnName = "id_zaaktype")
    lateinit var zaakType: ReferentieZaakTypeEntity

    @ManyToOne
    @JoinColumn(name = "id_tag", referencedColumnName = "id_document_tag")
    lateinit var tag: ReferentieTagEntity
}
