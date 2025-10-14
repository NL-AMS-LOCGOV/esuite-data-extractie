package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.*

@Entity
@Table(name = "ztc_zaaktype_documenttype", schema = "zakenmagazijn")
class ZaakTypeDocumentTypeEntity {

    @Id
    @Column(name = "id_zaaktype_documenttype")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_zaaktype", referencedColumnName = "id_zaaktype")
    lateinit var zaakType: ZaakTypeEntity

    @ManyToOne
    @JoinColumn(name = "id_documenttype", referencedColumnName = "id_documenttype")
    lateinit var documentType: DocumentTypeEntity

    // DSP code
    @Column(name = "dspcode", length = 255)
    var dspcode: String? = null

    @OneToMany(mappedBy = "zaakTypeDocumentType")
    lateinit var documentTitelKoppelingen: MutableSet<ZaakTypeDocumentTypeTitelEntity>
}
