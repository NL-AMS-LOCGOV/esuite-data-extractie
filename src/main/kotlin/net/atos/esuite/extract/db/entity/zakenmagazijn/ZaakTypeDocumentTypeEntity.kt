package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.*

@Entity
@Table(name = "ztc_zaaktype_documenttype", schema = "zakenmagazijn")
class ZaakTypeDocumentTypeEntity {

    @Id
    @Column(name = "id_zaaktype_documenttype")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_zaaktype", referencedColumnName = "id_zaaktype")
    lateinit var zaakType: ReferentieZaakTypeEntity

    @ManyToOne
    @JoinColumn(name = "id_documenttype", referencedColumnName = "id_documenttype")
    lateinit var documentType: ReferentieDocumentTypeEntity

    // DSP code
    @Column(name = "dspcode", length = 255)
    var dspcode: String? = null

    @OneToMany(mappedBy = "zaakTypeDocumentType")
    lateinit var documentTitelKoppelingen: MutableSet<ZaakTypeDocumentTypeTitelEntity>
}
