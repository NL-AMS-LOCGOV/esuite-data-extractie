package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.LocalDate


// Koppeltabel tussen zaken en betrokkenen
@Entity
@Table(name = "zkn_zaak_betrokkene", schema = "zakenmagazijn")
class ZaakBetrokkeneEntity {

    @Id
    @Column(name = "id_zaak_betrokkene")
    var identifier: Long = 0

    // Indicatie of correspondentie naar betrokkene gestuurd moet worden
    @Column(name = "ind_correspondentie")
    var indCorrespondentie = false

    // Startdatum betrokkenheid
    @Column(name = "startdatum")
    var startdatum: LocalDate? = null

    @Column(name = "id_betrokkene")
    var betrokkeneId: Long = 0

    @Column(name = "typebetrokkene", length = 64)
    lateinit var zaakBetrokkeneType: String

    @Column(name = "toelichting", length = Int.MAX_VALUE)
    @Lob
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    lateinit var toelichting: String

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity
}
