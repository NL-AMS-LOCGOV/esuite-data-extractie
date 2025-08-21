package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.time.LocalDate

@Embeddable
class OvergebrachteGegevensEntity {

    // Datum waarop de zaak is overgebracht
    @Column(name = "archief_overgebracht_op")
    lateinit var overgebrachtOp: LocalDate

    // Locatie/instantie waarnaar de zaak overgebracht is
    @Column(name = "archief_overgebracht_naar", length = 255)
    lateinit var overgebrachtNaar: String

    // Naam medewerker die de zaak heeft overgebracht
    @Column(name = "archief_overgebracht_door", length = 128)
    lateinit var overgebrachtDoor: String

}
