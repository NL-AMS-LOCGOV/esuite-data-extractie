package net.atos.esuite.extract.db.basisgegevens.entity

import jakarta.persistence.*

@Entity
@Table(name = "gm_contactpersoon", schema = "basisgegevens")
class ContactpersoonEntity {

    @Id
    @Column(name = "id_contactpersoon")
    var identifier: Long = 0

    @Column(name = "naam", length = 128)
    var naam: String? = null

    @Column(name = "geslacht", length = 1)
    var geslacht: String? = null

    @Column(name = "emailadres", length = 128)
    var emailadres: String? = null

    @Column(name = "telefoon", length = 20)
    var telefoon: String? = null

    @Column(name = "telefax", length = 20)
    var telefax: String? = null

    @Column(name = "functie", length = 64)
    var functie: String? = null

    @ManyToOne
    @JoinColumn(name = "id_bedrijf", referencedColumnName = "id_bedrijf")
    var bedrijf: BedrijfEntity? = null
}
