package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.*

@Entity
@Table(name = "ztc_ref_zaakrelatietype", schema = "zakenmagazijn")
class ReferentieZaaRelatietypeEntity {

    @Id
    @Column(name = "id_zaakrelatietype")
    lateinit var identifier: String

    // Naam van zaakrelatietype
    @Column(name = "naam", length = 255)
    lateinit var naam: String

    // Omschrijving van het zaakrelatietype
    @Column(name = "omschrijving")
    lateinit var omschrijving: String

    @OneToOne
    @JoinColumn(name = "id_inversezaakrelatietype")
    lateinit var inverseZaakrelatietype: ReferentieZaaRelatietypeEntity

    // Indicatie of zaakrelatie leidend in een relatie is
    @Column(name = "ind_hoofdrelatie")
    var indicatieHoofdrelatie = false
}
