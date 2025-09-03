package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.*

@Entity
@Table(name = "ztc_zaaktype_besluittype", schema = "zakenmagazijn")
class ZaakTypeBesluittypeEntity {

    @Id
    @Column(name = "id_zaaktype_besluittype")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_zaaktype", referencedColumnName = "id_zaaktype")
    lateinit var zaakType: ReferentieZaakTypeEntity

    @ManyToOne
    @JoinColumn(name = "id_besluittype", referencedColumnName = "id_besluittype")
    lateinit var besluittype: ReferentieBesluittypeEntity

    @ManyToOne
    @JoinColumn(name = "id_documenttype", referencedColumnName = "id_documenttype")
    var documentType: ReferentieDocumentTypeEntity? = null

    // Procestermijn in maanden
    @Column(name = "procestermijn_in_maanden")
    var procestermijnInMaanden: Int? = null
}
