package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.*
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_besluittype", schema = "zakenmagazijn")
class BesluittypeEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_besluittype")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_besluitcategorie")
    lateinit var besluitcategorie: BesluitcategorieEntity

    // Reactietermijn in dagen
    @Column(name = "reactietermijn_in_dagen")
    var reactietermijnInDagen: Int = 0

    // Publicatie indicatie
    @Column(name = "publicatie_indicatie")
    var publicatieIndicatie = false

    // Publicatietekst
    @Column(name = "publicatietekst")
    var publicatietekst: String? = null

    // Publicatie termijn in dagen
    @Column(name = "publicatietermijn_in_dagen")
    var publicatietermijnInDagen: Int? = null
}
