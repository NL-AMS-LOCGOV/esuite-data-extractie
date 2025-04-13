package net.atos.esuite.extract.entity.shared

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.LocalDate


@MappedSuperclass
abstract class AbstractHistoryEntity {

    // Datum waarop de wijziging heeft plaatsgevonden
    @Column(name = "datumwijziging")
    var datumwijziging: LocalDate? = null

    // Naam (Volledige naam) van de gebruiker
    @Column(name = "gewijzigddoor", length = 128)
    var gewijzigddoor: String? = null

    // De oude waarde van het type
    @Column(name = "oudewaarde", length = Int.MAX_VALUE)
    var oudewaarde: String? = null

    // De nieuwe waarde van het type
    @Column(name = "nieuwewaarde", length = Int.MAX_VALUE)
    var nieuwewaarde: String? = null

    // Toelichting of reden wijziging
    @Column(name = "toelichting", length = Int.MAX_VALUE)
    @Lob
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    var toelichting: String? = null

}
