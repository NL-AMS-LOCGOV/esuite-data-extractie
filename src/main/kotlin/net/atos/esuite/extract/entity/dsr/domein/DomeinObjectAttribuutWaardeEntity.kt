package net.atos.esuite.extract.entity.dsr.domein

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigDecimal
import java.time.Instant
import java.time.LocalDate

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
