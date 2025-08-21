package net.atos.esuite.extract.db.entity.zakenmagazijn.dataelement

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class AanvullijstRecordEntity {

    @Column(name = "recordnummer")
    var recordNummer: Int = 0

    @Column(name = "itemid", length = Int.MAX_VALUE)
    lateinit var itemID: String

    @Column(name = "itemwaarde", length = Int.MAX_VALUE)
    var itemWaarde: String? = null
}
