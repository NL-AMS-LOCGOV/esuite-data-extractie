package net.atos.esuite.extract.entity.basisgegevens

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "gm_adressen", schema = "basisgegevens")
class   AdresEntity {

    @Id
    @Column(name = "id_adres")
    var identifier: Long = 0

    @Column(name = "straatnaam", length = 64)
    var straatnaam: String? = null

    @Column(name = "postcode", length = 6)
    var postcode: String? = null

    @Column(name = "plaatsnaam", length = 128)
    var plaatsnaam: String? = null

    @Column(name = "huisletter", length = 10)
    var huisletter: String? = null

    @Column(name = "huisnummer", length = 10)
    var huisnummer: Int? = null

    @Column(name = "huisnummertoevoeging", length = 10)
    var huisnummertoevoeging: String? = null

    @Column(name = "huisnummeraanduiding", length = 64)
    var huisnummeraanduiding: String? = null

    @Column(name = "adresbuitenland1", length = 128)
    var adresbuitenland1: String? = null

    @Column(name = "adresbuitenland2", length = 128)
    var adresbuitenland2: String? = null

    @Column(name = "adresbuitenland3", length = 128)
    var adresbuitenland3: String? = null

    @Column(name = "ind_buitenlandsadres")
    var indicatieBuitenlandsadres = false

    @ManyToOne
    @JoinColumn(name = "id_land", referencedColumnName = "gbacode")
    lateinit var land: ReferentieLandEntity
}
