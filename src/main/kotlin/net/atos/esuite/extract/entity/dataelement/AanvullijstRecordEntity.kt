package net.atos.esuite.extract.entity.dataelement

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class AanvullijstRecordEntity {

    @Column(name = "recordnummer")
    lateinit var recordNummer: java.lang.Integer

    @Column(name = "itemid", length = Int.MAX_VALUE)
    lateinit var itemID: String

    @Column(name = "itemwaarde", length = Int.MAX_VALUE)
    var itemWaarde: String? = null
}
