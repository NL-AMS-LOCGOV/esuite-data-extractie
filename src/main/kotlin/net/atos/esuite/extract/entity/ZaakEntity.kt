package net.atos.esuite.extract.entity

import jakarta.persistence.*
import java.time.Instant
import java.time.LocalDate


@Entity
@Table(name = "zkn_zaak", schema = "zakenmagazijn")
class ZaakEntity {

    @Id
    @Column(name = "id_zaak")
    lateinit var identifier: java.lang.Long

    // ID-nummer tabel ZTC Zaaktype
    @Column(name = "id_zaaktype", length = 64)
    lateinit var zaaktypeId: String

    @Column(name = "id_functioneel", unique = true, length = 128)
    lateinit var functioneelId: String

    // Externe zaakidentificatie
    @Column(name = "id_functioneel_extern", unique = true, length = 40)
    lateinit var externFunctioneelId: String

    // ID-nummer tabel ID_Kanalen
    @OneToOne
    @JoinColumn(name = "id_kanaal", referencedColumnName = "id_kanaal")
    var kanaal: ReferentieKanaalEntity? = null

    // Afdeling waar zaak in behandeling is
    @Column(name = "id_afdeling", length = 128)
    var afdelingId: String? = null

    // Groep waar zaak in behandeling is
    @Column(name = "id_groep", length = 128)
    var groepId: String? = null

    // Gebruiker waar zaak in behandeling is
    @Column(name = "id_behandelaar", length = 64)
    var behandelaarId: String? = null

    // ToDo: ID-nummer van het subject (uit basisgegevens) dat de zaak heeft opgestart
    @Column(name = "id_initiator")
    var initiatorId: Long? = null

    // Medewerker die de zaak heeft aangemaakt
    @Column(name = "id_aangemaaktdoor", length = 64)
    var aangemaaktDoorId: String? = null

    // ToDo: Entity
    @Column(name = "id_zaakstatus", length = 255)
    lateinit var statusId: String

    // ToDo: Entity
    @Column(name = "id_zaakresultaat", length = 255)
    var resultaatId: String? = null

    // Datum waarop de behandeling van deze zaak is / wordt gestart
    @Column(name = "startdatum")
    var startdatum: LocalDate? = null

    // Streefdatum van de zaak
    @Column(name = "streefdatum")
    lateinit var streefdatum: LocalDate

    // Fataledatum van de zaak
    @Column(name = "fataledatum")
    var fataledatum: LocalDate? = null

    // Einddatum van de zaak
    @Column(name = "einddatum")
    var einddatum: LocalDate? = null

    // Tijdstip waarop de zaak is geinsert.
    @Column(name = "creatiedatumtijd")
    lateinit var creatiedatum: Instant

    // Tijdstip waarop de laatste zaakhistory is geinsert.
    @Column(name = "wijzigdatumtijd")
    var wijzigdatum: Instant? = null

    // Begindatum van een nu lopende opschorttermijn
    @Column(name = "opschorttermijn_startdatum")
    var opschorttermijnStartdatum: LocalDate? = null

    // Einddatum van een nu lopende opschorttermijn
    @Column(name = "opschorttermijn_einddatum")
    var opschorttermijnEinddatum: LocalDate? = null

    // Algemene omschrijving van de zaak
    @Column(name = "omschrijving", length = Integer.MAX_VALUE)
    lateinit var omschrijving: String

    // Reden van het starten van de zaak
    @Column(name = "redenstartzaak", length = Integer.MAX_VALUE)
    var redenStartZaak: String? = null

    // Indicator die aangeeft dat de zaak beëindigd en weer heropend is (wat betekent dat het bijbehorende proces niet meer bestaat)
    @Column(name = "ind_heropend")
    var indicatieHeropend = false

    // Aanduiding vertrouwelijke zaak
    @Column(name = "ind_vertrouwelijk")
    var indicatieVertrouwelijk = false

    // Aanduiding dat het een intake betreft
    @Column(name = "ind_intake")
    var indicatieIntake = false

    // Indicatie of de zaak in vernietiging is
    @Column(name = "ind_in_vernietiging")
    var inVernietiging = false

    @Column(name = "notificeerbaar")
    var notificeerbaar = false

    @OneToMany(mappedBy = "zaak")
    var taken: MutableSet<TaakEntity> = mutableSetOf()

    @OneToMany(mappedBy = "zaak")
    var betrokkenen: MutableSet<ZaakBetrokkeneEntity> = mutableSetOf()

    @OneToMany(mappedBy = "zaak")
    @OrderBy(value = "identifier")
    var notities: MutableSet<ZaakNotitieEntity> = mutableSetOf()

    @OneToMany(mappedBy = "zaak")
    var gekoppeldeBAGObjecten: MutableSet<ZaakBAGObjectEntity> = mutableSetOf()

    // Alle zaakrelaties waarin de huidige zaak de volgende zaak is
    @OneToMany(mappedBy = "gekoppeldeZaak")
    var relatieZaken: MutableSet<ZaakZaakEntity> = mutableSetOf()

    @Embedded
    var archiveergegevens: ArchiveergegevensEntity? = null

    @Embedded
    var betaalgegevens: BetaalgegevensEntity? = null

    @OneToMany(mappedBy = "zaak")
    @OrderBy("identifier DESC")
    var historie: MutableSet<ZaakHistorieEntity> = mutableSetOf()

    @OneToMany(mappedBy = "zaak")
    var documenten: MutableSet<DocumentEntity> = mutableSetOf()

    @OneToMany(mappedBy = "zaak")
    var zaakdataElementen: MutableSet<AbstractDataElementEntity> = mutableSetOf()

    // ToDo: Locatie van de zaak gedefinieerd als een valide WKT representatie string
    @Column(name = "geolocatie", length = Integer.MAX_VALUE)
    var geolocatie: String? = null

    // ToDo: Organisatie behorende bij de zaak
    @Column(name = "id_organisatie")
    var organisatieId: Long? = null

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "zkn_zaak_geautoriseerde_medewerker", schema = "zakenmagazijn", joinColumns = [JoinColumn(name = "id_zaak")])
    @Column(name = "medewerker")
    var geautoriseerdeMedewerkers: MutableSet<String> = mutableSetOf()

    // Of autorisatie op dit element aan of uit staat
    @Column(name = "autorisatie")
    var autorisatie = false

    // Is voor de zaak een proces gestart
    @Column(name = "proces_gestart")
    var procesGestart = true

    @OneToMany(mappedBy = "zaak", fetch = FetchType.LAZY)
    var besluiten: MutableSet<BesluitEntity> = mutableSetOf()

    // ToDo: Contacten gekoppeld aan Zaak
}
