package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.*
import net.atos.esuite.extract.entity.basisgegevens.SubjectEntity
import net.atos.esuite.extract.entity.configuratiemagazijn.ReferentieKanaalEntity
import net.atos.esuite.extract.entity.configuratiemagazijn.ReferentieOrganisatieEntity
import net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractDataElementEntity
import java.time.Instant
import java.time.LocalDate


@Entity
@Table(name = "zkn_zaak", schema = "zakenmagazijn")
class ZaakEntity {

    @Id
    @Column(name = "id_zaak")
    var identifier: Long = 0

    // ID-nummer tabel ZTC Zaaktype
    @Column(name = "id_zaaktype", length = 64)
    lateinit var zaaktypeId: String

    @Column(name = "id_functioneel", unique = true, length = 128)
    lateinit var functioneelId: String

    // Externe zaakidentificatie
    @Column(name = "id_functioneel_extern", unique = true, length = 40)
    lateinit var externFunctioneelId: String

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kanaal", referencedColumnName = "id_kanaal")
    lateinit var kanaal: ReferentieKanaalEntity

    // Afdeling waar zaak in behandeling is
    @Column(name = "id_afdeling", length = 128)
    var afdelingId: String? = null

    // Groep waar zaak in behandeling is
    @Column(name = "id_groep", length = 128)
    var groepId: String? = null

    // Gebruiker waar zaak in behandeling is
    @Column(name = "id_behandelaar", length = 64)
    var behandelaarId: String? = null

    @Column(name = "id_initiator")
    var initiatorId: Long? = null

    // Medewerker die de zaak heeft aangemaakt
    @Column(name = "id_aangemaaktdoor", length = 64)
    lateinit var aangemaaktDoorId: String

    @Column(name = "id_zaakstatus", length = 255)
    lateinit var statusId: String

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
    @Column(name = "omschrijving", length = Int.MAX_VALUE)
    lateinit var omschrijving: String

    // Reden van het starten van de zaak
    @Column(name = "redenstartzaak", length = Int.MAX_VALUE)
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

    @OneToMany(mappedBy = "zaak", fetch = FetchType.LAZY)
    var taken: MutableSet<TaakEntity> = mutableSetOf()

    @OneToMany(mappedBy = "zaak", fetch = FetchType.LAZY)
    var betrokkenen: MutableSet<ZaakBetrokkeneEntity> = mutableSetOf()

    @OneToMany(mappedBy = "zaak", fetch = FetchType.LAZY)
    @OrderBy(value = "identifier")
    var notities: MutableSet<ZaakNotitieEntity> = mutableSetOf()

    @OneToMany(mappedBy = "zaak", fetch = FetchType.LAZY)
    var gekoppeldeBAGObjecten: MutableSet<ZaakBAGObjectEntity> = mutableSetOf()

    // Alle zaakrelaties waarin de huidige zaak de volgende zaak is
    @OneToMany(mappedBy = "gekoppeldeZaak", fetch = FetchType.LAZY)
    var relatieZaken: MutableSet<ZaakZaakEntity> = mutableSetOf()

    @Embedded
    var archiveergegevens: ArchiveergegevensEntity? = null

    @Embedded
    var betaalgegevens: BetaalgegevensEntity? = null

    @OneToMany(mappedBy = "zaak", fetch = FetchType.LAZY)
    @OrderBy("identifier DESC")
    var historie: MutableSet<ZaakHistorieEntity> = mutableSetOf()

    @OneToMany(mappedBy = "zaak", fetch = FetchType.LAZY)
    var documenten: MutableSet<DocumentEntity> = mutableSetOf()

    @OneToMany(mappedBy = "zaak", fetch = FetchType.LAZY)
    var zaakdataElementen: MutableSet<AbstractDataElementEntity> = mutableSetOf()

    // Locatie van de zaak gedefinieerd als een valide WKT representatie string
    @Column(name = "geolocatie", length = Int.MAX_VALUE)
    var geolocatie: String? = null

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_organisatie", referencedColumnName = "id_organisatie")
    var organisatie: ReferentieOrganisatieEntity? = null

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "zkn_zaak_geautoriseerde_medewerker", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_zaak")]
    )
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

    @OneToMany(mappedBy = "zaak", fetch = FetchType.LAZY)
    var contacten: MutableSet<ZaakContactEntity> = mutableSetOf()
}
