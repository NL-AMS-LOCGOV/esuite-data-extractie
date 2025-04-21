package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.LocalDate


/**
 * Entity voor een besluit, behorende bij een zaak.
 */
@Entity
@Table(name = "zkn_besluit", schema = "zakenmagazijn")
class BesluitEntity {

    @Id
    @Column(name = "id_besluit")
    var identifier: Long = 0

    // Functionele identificatie van het besluit
    @Column(name = "id_functioneel", unique = true, length = 128)
    lateinit var functioneelId: String

    @Column(name = "id_besluittype", length = 128)
    lateinit var besluittypeId: String

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity

    @ManyToOne
    @JoinColumn(name = "id_document", referencedColumnName = "id_document")
    var document: DocumentEntity? = null

    @Column(name = "id_documenttype", length = 128)
    var documenttypeId: String? = null

    // Datum waarop het besluit is aangemaakt
    @Column(name = "besluitdatum")
    lateinit var besluitdatum: LocalDate

    // Datum vanaf wanneer het besluit geldig is
    @Column(name = "ingangsdatum")
    var ingangsdatum: LocalDate? = null

    // Datum waarop het besluit vervalt
    @Column(name = "vervaldatum")
    var vervaldatum: LocalDate? = null

    // Geeft aan of de vervaldatum moet worden berekend op het moment dat de zaak beeindigd wordt
    @Column(name = "bereken_vervaldatum")
    var berekenVervaldatum = false

    // Uiterlijke reactie datum
    @Column(name = "reactiedatum")
    var reactiedatum: LocalDate? = null

    // Publicatie  datum van het beluit
    @Column(name = "publicatiedatum")
    var publicatiedatum: LocalDate? = null

    // Toelichting op het besluit
    @Column(name = "toelichting")
    @Lob
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    var toelichting: String? = null

    // Procestermijn in maanden voor berekening van de vervaldatum
    @Column(name = "procestermijn_in_maanden")
    var procestermijnInMaanden: Int? = null
}
