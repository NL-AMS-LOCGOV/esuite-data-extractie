package net.atos.esuite.extract.entity.dsr.definitie

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

/**
 * Class voor de koppeling-opties die bij een DomeinObjectDefinitieEntity horen.
 * Hoewel dit een embeddable class is, zitten de data toch in een aparte tabel omdat het hier een many-to-one relatie betreft.
**/

@Embeddable
class DomeinObjectDefinitieKoppelbaarAanEntity {

    // Geeft aan dat koppeling met betreffende objecttype mogelijk is (ZAAK, CONTACT, BAG_OBJECT, PERSOON, BEDRIJF)
    @Column(name = "koppelbaar_aan_type", length = 64)
    lateinit var koppelbaarAanType: String
}
