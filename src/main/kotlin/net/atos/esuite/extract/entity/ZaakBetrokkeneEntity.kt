package net.atos.esuite.extract.entity

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
    lateinit var identifier: java.lang.Long

    // Indicatie of correspondentie naar betrokkene gestuurd moet worden
    @Column(name = "ind_correspondentie")
    var indCorrespondentie = false

    // Startdatum betrokkenheid
    @Column(name = "startdatum")
    var startdatum: LocalDate? = null

    // ToDo: Entity ID-nummer tabel ZKN_Betrokkenen
    @Column(name = "id_betrokkene")
    lateinit var idBetrokkene: java.lang.Long

    @Column(name = "typebetrokkene", length = 64)
    lateinit var zaakBetrokkeneType: String

    @Column(name = "toelichting", length = Integer.MAX_VALUE)
    @Lob
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    lateinit var toelichting: String

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity
}
