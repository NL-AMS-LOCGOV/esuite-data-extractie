package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.*


// Koppeltabel voor zaken onderling
@Entity
@Table(name = "zkn_zaak_zaak", schema = "zakenmagazijn")
class ZaakZaakEntity {

    @Id
    @Column(name = "id_zaak_zaak")
    var identifier: Long = 0

    @Column(name = "id_relatietype", length = 32)
    lateinit var relatietypeId: String

    @Column(name = "ind_eigenaar")
    var dossierEigenaar = false

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity

    @ManyToOne
    @JoinColumn(name = "id_gekoppelde_zaak", referencedColumnName = "id_zaak")
    lateinit var gekoppeldeZaak: ZaakEntity
}
