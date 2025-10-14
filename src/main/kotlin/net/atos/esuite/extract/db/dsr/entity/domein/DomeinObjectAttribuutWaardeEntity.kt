package net.atos.esuite.extract.db.dsr.entity.domein

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

/**
 * Implementatie van AbstractAttribuutWaardeEntity voor een domeinobject-waarde.
 * Dit is een referentie naar een DomeinObjectEntity binnen hetzelfde domein.
*/

@Entity
@DiscriminatorValue("OBJECTREFERENTIE")
class DomeinObjectAttribuutWaardeEntity : AbstractAttribuutWaardeEntity() {

    @ManyToOne
    @JoinColumn(name = "id_domein_object", referencedColumnName = "id_domein_object")
    lateinit var domeinObject: DomeinObjectEntity
}
