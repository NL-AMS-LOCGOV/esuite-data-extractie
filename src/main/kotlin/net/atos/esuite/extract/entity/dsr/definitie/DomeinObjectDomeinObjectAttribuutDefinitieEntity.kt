package net.atos.esuite.extract.entity.dsr.definitie

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

/**
 * Definitie van een attribuut met als waarde een referentie naar een ander object in hetzelfde domein.
 */

@Entity
@DiscriminatorValue("OBJECTREFERENTIE")
class DomeinObjectDomeinObjectAttribuutDefinitieEntity : AbstractAttribuutDefinitieEntity() {

    @ManyToOne
    @JoinColumn(name = "id_def_domein_object_referentie", referencedColumnName = "id_def_domein_object")
    lateinit var domeinObjectDefinitieReferentie: DomeinObjectDefinitieEntity
}
