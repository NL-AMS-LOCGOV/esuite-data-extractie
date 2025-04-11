package net.atos.esuite.extract.entity

import jakarta.persistence.*
import org.hibernate.annotations.Comment
import java.time.LocalDate

@Embeddable
class OvergebrachteGegevensEntity {

    // Datum waarop de zaak is overgebracht
    @Column(name = "archief_overgebracht_op")
    var overgebrachtOp: LocalDate? = null

    // Locatie/instantie waarnaar de zaak overgebracht is
    @Column(name = "archief_overgebracht_naar", length = 255)
    var overgebrachtNaar: String? = null

    // Naam medewerker die de zaak heeft overgebracht
    @Column(name = "archief_overgebracht_door", length = 128)
    var overgebrachtDoor: String? = null

}
