package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.*
import java.time.LocalDate


@Embeddable
class DocumentPublicatieEntity {

    enum class Bestemming {
        BERICHTENBOX
    }

    @Column(name = "bestemming", length = 20)
    @Enumerated(EnumType.STRING)
    var bestemming: Bestemming? = null

    @Column(name = "publicatiedatum")
    lateinit var publicatiedatum: LocalDate
}
