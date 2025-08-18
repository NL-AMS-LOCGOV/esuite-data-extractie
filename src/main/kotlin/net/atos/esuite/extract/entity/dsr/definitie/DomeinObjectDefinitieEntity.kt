package net.atos.esuite.extract.entity.dsr.definitie

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OrderBy
import jakarta.persistence.Table

/**
 * Entity class voor de definitie van een DSR-domeinobject.
*/

@Entity
@Table(name = "dsr_def_domein_object", schema = "dsr")
class DomeinObjectDefinitieEntity {

    @Id
    @Column(name = "id_def_domein_object")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_def_domein", referencedColumnName = "id_def_domein")
    lateinit var domeinDefinitie: DomeinDefinitieEntity

    // Naam van type object
    @Column(name = "naam", length = 128)
    lateinit var naam: String

    // Omschrijving van type object
    @Column(name = "omschrijving")
    var omschrijving: String? = null

    @OneToMany(mappedBy = "domeinObjectDefinitie")
    @OrderBy("volgnummer ASC")
    lateinit var attribuutDefinities: MutableList<AbstractAttribuutDefinitieEntity>

    @ElementCollection
    @CollectionTable(
        name = "dsr_def_domein_object_koppelbaar_aan", schema = "dsr",
        joinColumns = [JoinColumn(name = "id_def_domein_object", referencedColumnName = "id_def_domein_object")]
    )
    lateinit var koppelbaarAanTypes: List<DomeinObjectDefinitieKoppelbaarAanEntity>
}
