package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate


@Embeddable
class BetaalgegevensEntity {

    // Betaal status (Ogone)
    @Column(name = "betaal_status", length = 20)
    @Enumerated(EnumType.STRING)
    var betaalstatus: BetaalstatusEnum? = null

    // Status van de betaling (Ogone)
    @Column(name = "betaling_status_originele_code", length = 64)
    var origineleStatusCode: String? = null

    // Kenmerk 1 van de betaling (Ogone)
    @Column(name = "betaling_transactieid", length = 64)
    var transactieId: String? = null

    // Kenmerk 2 van de betaling (Ogone)
    @Column(name = "betaling_kenmerk", length = 64)
    var kenmerk: String? = null

    // Bedrag van de betaling (Ogone)
    @Column(name = "betaling_bedrag", length = 19, precision = 9)
    var bedrag: BigDecimal? = null

    // Foutcode van de betaling (Ogone)
    @Column(name = "betaling_ncerror", length = 64)
    var ncerror: String? = null

    // Transactiedatum van de betaling (Ogone)
    @Column(name = "betaling_transactiedatum")
    @Temporal(TemporalType.DATE)
    var transactieDatum: LocalDate? = null
}
