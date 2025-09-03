package net.atos.esuite.extract.db.entity.basisgegevens

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "gm_bedrijf", schema = "basisgegevens")
@PrimaryKeyJoinColumn(name = "id_bedrijf", referencedColumnName = "id_subject")
class BedrijfEntity : SubjectEntity() {

    // Kamer van Koophandelnummer
    @Column(name = "kvknummer", length = 8)
    var kvknummer: String? = null

    // Nummer van de vestiging (uniek identificerend)
    @Column(name = "vestigingsnummer", length = 12)
    var vestigingsnummer: String? = null

    @Column(name = "buitenlandshandelsregisternummer", length = 255)
    var buitenlandsHandelsregisternummer: String? = null

    // De volledige bedrijfsnaam zoals bekend bij de KvK
    @Column(name = "bedrijfsnaam", length = 128)
    var bedrijfsnaam: String? = null

    // Vennootschapsnaam
    @Column(name = "vennootschapsnaam", length = 255)
    var vennootschapsnaam: String? = null

    // Plaats van de statutaire zetel
    @Column(name = "statutairezetel", length = 64)
    var statutaireZetel: String? = null

    // Datum vestiging onderneming
    @Column(name = "datumvestiging")
    var datumVestiging: LocalDate? = null

    // Datum opheffing onderneming
    @Column(name = "datumopheffing")
    var datumOpheffing: LocalDate? = null

    // Datum voortzetting onderneming
    @Column(name = "datumvoortzetting")
    var datumVoortzetting: LocalDate? = null

    // Telefoonnummer
    @Column(name = "telefoon", length = 20)
    var telefoon: String? = null

    // Alternatief telefoonnummer
    @Column(name = "telefoonnummer_alternatief", length = 20)
    var telefoonnummerAlternatief: String? = null

    // Telefaxnumer
    @Column(name = "telefax", length = 20)
    var telefax: String? = null

    // Emailadres
    @Column(name = "emailadres", length = 128)
    var emailadres: String? = null

    @Column(name = "ontvangen_zaak_notificaties")
    var ontvangenZaakNotificaties: Boolean? = null

    // Nummer bankrekening
    @Column(name = "bankrekening", length = 64)
    var bankrekening: String? = null

    // Totaal aantal werknemers
    @Column(name = "aantalwerknemers")
    var aantalWerknemers: Int? = null

    // Indicatie surseance van betaling
    @Column(name = "ind_surseance")
    var indSurseance = false

    // Indicatie van faillisement
    @Column(name = "ind_faillisement")
    var indFaillisement = false

    // Aanduiding of het bedrijf handmatig is toegevoegd
    @Column(name = "ind_handmatigtoegevoegd")
    var indicatieHandmatigToegevoegd = false

    // RSINummer onderneming
    @Column(name = "rsinummer", length = 20)
    var rsinummer: String? = null

    // Code status vestiging
    @Column(name = "statusvestiging", length = 1)
    var statusVestiging: String? = null

    // FI nummer van de eigenaar
    @Column(name = "finummereigenaar", length = 20)
    var fiNummerEigenaar: String? = null

     // Ingangsdatum geldigheid record vanaf
    @Column(name = "ingangsdatum")
    lateinit var ingangsdatum: LocalDate

    @Column(name = "mutatiedatum")
    var mutatiedatum: LocalDate? = null

    // Aanduiding of het een hoofdvestiging betreft
    @Column(name = "ind_hoofdvestiging")
    var indHoofdVestiging: Boolean? = null

    // Indicatie of het bedrijf notificaties van een zaak wil ontvangen
    @Column(name = "toestemmingZaakNotificatiesAlleenDigitaal")
    var toestemmingZaakNotificatiesAlleenDigitaal: Boolean? = null

    // sleutel van de hoofdactiviteit
    @ManyToOne
    @JoinColumn(name = "id_hoofdactiviteit", referencedColumnName = "id_hoofdactiviteit")
    var hoofdactiviteit: HoofdactiviteitEntity? = null

    // Rechtsvorm
    @ManyToOne
    @JoinColumn(name = "id_rechtsvorm", referencedColumnName = "id_rechtsvorm")
    var rechtsvorm: RechtsvormEntity? = null

    @OneToMany(mappedBy = "bedrijf")
    lateinit var adressen: MutableSet<BedrijfAdresEntity>

    @ManyToMany
    @JoinTable(
        name = "gm_bedrijfnevenactiviteit", schema = "basisgegevens",
        joinColumns = [JoinColumn(name = "id_bedrijf")],
        inverseJoinColumns = [JoinColumn(name = "id_nevenactiviteit")]
    )
    lateinit var nevenactiviteiten: MutableSet<NevenactiviteitEntity>

    @OneToMany(mappedBy = "bedrijf")
    lateinit var contactpersonen: MutableSet<ContactpersoonEntity>
}
