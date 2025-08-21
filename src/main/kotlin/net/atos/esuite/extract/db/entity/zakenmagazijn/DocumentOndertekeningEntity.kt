package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.*
import java.time.Instant
import java.time.LocalDate


@Entity
@Table(name = "zkn_documentondertekening", schema = "zakenmagazijn")
class DocumentOndertekeningEntity {

    @Id
    @Column(name = "id_documentondertekening")
    var identifier: Long = 0

    // Titel van het document bij ondertekening
    @Column(name = "documenttitel", length = 256)
    lateinit var documentTitel: String

    @Column(name = "ondertekenaar", length = 128)
    lateinit var ondertekenaar: String

    // Datum waarop de versie werd ondertekend
    @Column(name = "ondertekendatum")
    lateinit var ondertekenDatum: Instant

    // Datum waarop de ondertekening van de versie werd aangemaakt
    @Column(name = "creatiedatum")
    lateinit var creatieDatum: LocalDate

    // Opmerkingen over de ondertekening van de versie
    @Column(name = "opmerkingen", length = Int.MAX_VALUE)
    var opmerking: String? = null

    @ManyToOne
    @JoinColumn(name = "id_documentversie", referencedColumnName = "id_documentversie")
    lateinit var documentVersie: DocumentVersieEntity

    // Ondertekening is wel of niet gemandateerd
    @Column(name = "gemandateerd")
    var gemandateerd = false
}
