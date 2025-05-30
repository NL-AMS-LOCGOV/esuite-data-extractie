package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.*
import java.time.Instant
import java.time.LocalDate


@Entity
@Table(name = "zkn_taak", schema = "zakenmagazijn")
class TaakEntity {

    @Id
    @Column(name = "id_taak")
    var identifier: Long = 0

    @Column(name = "id_afdeling", length = 128)
    var afdelingId: String? = null

    @Column(name = "id_functioneel", unique = true, length = 128)
    lateinit var functioneelId: String

    @Column(name = "id_groep", length = 128)
    var groepId: String? = null

    @Column(name = "id_behandelaar", length = 64)
    var behandelaarId: String? = null

    // Startdatum van de taak
    @Column(name = "startdatum")
    lateinit var startdatum: LocalDate

    // Streefdatum van de taak
    @Column(name = "streefdatum")
    var streefdatum: LocalDate? = null

    // Fatale datum van de taak
    @Column(name = "fataledatum")
    var fataledatum: LocalDate? = null

    // Einddatum van de taak
    @Column(name = "einddatumtijd")
    var einddatum: Instant? = null

    // Referentie van de externe taak
    @Column(name = "id_procestaak", length = 255)
    var procesTaakId: String? = null

    // Indicatie externe taak
    @Column(name = "ind_externToegankelijk")
    var indicatieExternToegankelijk = false

    // Naam van gebruiker, afdeling of groep die taak heeft afgehandeld
    @Column(name = "afgehandeldDoor", length = 255)
    var afgehandeldDoor: String? = null

    @Column(name = "processtap", length = 255)
    var processtap: String? = null

    // Type van de taak
    @Column(name = "taak_type", length = 255)
    lateinit var taakType: String

    // Het originele taaktype waarmee de taak aangemaakt is.
    @Column(name = "taak_type_origineel", length = 255)
    lateinit var taakTypeOrigineel: String

    // Datum tot wanneer een taak is opgeschort
    @Column(name = "opschorttermijn_startdatum")
    var opschorttermijnStartdatum: LocalDate? = null

    @Column(name = "opschorttermijn_einddatum")
    var opschorttermijnEinddatum: LocalDate? = null

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity

    @OneToMany(mappedBy = "taak")
    var historie: MutableList<TaakHistorieEntity> = mutableListOf()

    // Emails voor notificatie/herinneringsemail voor een externe taak
    @Column(name = "toekenning_email")
    var toekenningEmail: String? = null

    // Om een taak te koppelen aan een vestigingsnummer.
    @Column(name = "vestigingsnummer")
    var vestigingsnummer: String? = null

    // Om een taak te koppelen aan een kvknummer.
    @Column(name = "kvknummer")
    var kvkNummer: String? = null

    // Het authenticatieniveau benodigd voor externen
    @Column(name = "authenticatieniveau", length = 4)
    var authenticatieniveau: String? = null
}
