package net.atos.esuite.extract.db.entity.dsr.definitie

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

/**
 * Definitie van een attribuut met als waarde een referentie naar een waarde uit een referentietabel.
*/

@Entity
@DiscriminatorValue("REFERENTIETABEL")
class DomeinObjectReferentietabelAttribuutDefinitieEntity : AbstractAttribuutDefinitieEntity() {

    @ManyToOne
    @JoinColumn(name = "id_def_referentietabel", referencedColumnName = "id_def_referentietabel")
    lateinit var referentietabel: ReferentietabelDefinitieEntity

}
