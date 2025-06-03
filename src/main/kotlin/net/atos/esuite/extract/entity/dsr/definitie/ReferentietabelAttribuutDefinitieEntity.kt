package net.atos.esuite.extract.entity.dsr.definitie

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

/**
 * Entity class voor de definitie van een referentietabel attribuut.
*/

@Entity
@Table(name = "dsr_def_referentietabel_attribuut", schema = "dsr")
class ReferentietabelAttribuutDefinitieEntity {

    @Id
    @Column(name = "id_def_referentietabel_attribuut")
    var identifier: Long = 0

    @Column(name = "volgnummer")
    var volgnummer: Int = 0

    // Naam van attribuut
    @Column(name = "naam", length = 128)
    lateinit var naam: String

    // Omschrijving van attribuut
    @Column(name = "omschrijving")
    var omschrijving: String? = null

    // Attribuut verplicht in te vullen in het data model
    @Column(name = "verplicht")
    var verplicht = false

    // Datatype (STRING, NUMMER, DECIMAAL, BOOLEAN, DATUM, DATUM_MET_TIJDSTIP, GEO_INFORMATIE, MEMO)
    @Column(name = "datatype", length = 64)
    lateinit var datatype: String

    @ManyToOne
    @JoinColumn(name = "id_def_referentietabel", referencedColumnName = "id_def_referentietabel")
    lateinit var referentietabel: ReferentietabelDefinitieEntity
}
