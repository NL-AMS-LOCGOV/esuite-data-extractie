package net.atos.esuite.extract.entity

import jakarta.persistence.*
import java.time.LocalDate


@Embeddable
class DocumentPublicatieEntity {

    enum class Bestemming {
        BERICHTENBOX
    }

    @Column(name = "bestemming", length = 20)
    @Enumerated(EnumType.STRING)
    var bestemming: DocumentPublicatieEntity.Bestemming? = null

    @Column(name = "publicatiedatum")
    lateinit var publicatiedatum: LocalDate
}
