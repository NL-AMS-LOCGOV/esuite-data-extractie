package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.*
import net.atos.esuite.extract.db.entity.shared.AbstractReferentieEntity
import java.time.Instant

@Entity
@Table(name = "ztc_ref_zaaktype", schema = "zakenmagazijn")
class ReferentieZaakTypeEntity : AbstractReferentieEntity(){

    @Id
    @Column(name = "id_zaaktype")
    var identifier: Long = 0

    @Column(name = "id_functioneel", length = 128)
    lateinit var functioneelId: String

    @ManyToOne
    @JoinColumn(name = "id_handelinginitiator", referencedColumnName = "id_handelinginitiator")
    lateinit var handelingInitiator: ReferentieHandelingInitiatorEntity

    @Column(name = "intern_extern", length = 20)
    @Enumerated(EnumType.STRING)
    lateinit var internExtern: InternExtern

    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie")
    lateinit var categorie: ReferentieCategorieEntity

    @Column(name = "id_initiele_afdeling", length = 255)
    var idInitieleAfdeling: String? = null

    @Column(name = "id_initiele_groep", length = 255)
    var idInitieleGroep: String? = null

    @ManyToOne
    @JoinColumn(name = "id_iv3categorie", referencedColumnName = "id_iv3categorie")
    lateinit var iv3categorie: ReferentieIv3CategorieEntity

    // Aanduiding intake'
    @Column(name = "ind_intake")
    var indicatieIntake: Boolean = false

    // Datum begin geldigheid
    @Column(name = "begin_geldigheid")
    lateinit var beginGeldigheid: Instant

    // Datum einde geldigheid
    @Column(name = "einde_geldigheid")
    var eindeGeldigheid: Instant? = null

    // Gewenste doorlooptijd
    @Column(name = "doorlooptijd_gewenst")
    var doorlooptijdGewenst: Int? = null

    // Het aantal dagen voorafgaand aan de streefdatum waarop de 1ste signalering plaats vindt
    @Column(name = "aantal_dagen_voor_streefdatum_voor_eerste_signalering")
    var aantalDagenVoorStreefdatumVoorEersteSignalering: Int = 0

    // Het aantal dagen voorafgaand aan de streefdatum waarop de 2de signalering plaats vindt
    @Column(name = "aantal_dagen_voor_streefdatum_voor_tweede_signalering")
    var aantalDagenVoorStreefdatumVoorTweedeSignalering: Int = 0

    // Maximale doorlooptijd
    @Column(name = "doorlooptijd_vereist")
    var doorlooptijdVereist: Int? = null

    // Het aantal dagen voorafgaand aan de fataledatum waarop de 1ste signalering plaats vindt
    @Column(name = "aantal_dagen_voor_fataledatum_voor_eerste_signalering")
    var aantalDagenVoorFataledatumVoorEersteSignalering: Int = 0

    // Het aantal dagen voorafgaand aan de fataledatum waarop de 2de signalering plaats vindt
    @Column(name = "aantal_dagen_voor_fataledatum_voor_tweede_signalering")
    var aantalDagenVoorFataledatumVoorTweedeSignalering: Int = 0

    // Aanduiding doorlooptijd aanpassen toegestaan
    @Column(name = "ind_doorlooptijd_aanpassen_toegestaan")
    var indicatieDoorlooptijdAanpassenToegestaan: Boolean = false

    @ManyToOne
    @JoinColumn(name = "id_initielestatus", referencedColumnName = "id_zaakstatus")
    var initieleStatus: ReferentieZaakStatusEntity? = null

    // Archivering Reviewperiode in weken
    @Column(name = "archivering_reviewperiode_in_weken")
    var archiveringReviewPeriodeInWeken: Int? = null

    // Functionele identificatie voor het proces
    @Column(name = "fid_proces", length = 128)
    var fidProces: String? = null

    // Functionele identificatie voor het zaakformulier
    @Column(name = "fid_formulierdefinitie", length = 128)
    var fidFormulierdefinitie: String? = null

    // Optionele versie nummer van het zaakformulier
    @Column(name = "fid_formulierdefinitie_versie")
    var fidFormulierdefinitieVersie: Long? = null

    // Indicator of zaken van dit type in principe vertrouwelijk behandeld moeten worden
    @Column(name = "ind_vertrouwelijk")
    var indVertrouwelijk: Boolean = false

    // Indicatie gebruik maken van zaaktype specifieke set tags
    @Column(name = "ind_zaaktypetags")
    var indZaakTypeTags: Boolean = false

    @Column(name = "notificatiesVersturen")
    var notificatiesVersturen: Boolean = false

    @OneToMany(mappedBy = "zaakType")
    lateinit var zaakTypeZaakResultaten: MutableSet<ZaakTypeZaakResultaatEntity>

    @OneToMany(mappedBy = "zaakType")
    lateinit var zaakTypeDocumentTypen: MutableSet<ZaakTypeDocumentTypeEntity>

    @OneToMany(mappedBy = "zaakType")
    lateinit var zaakTypeTags: MutableSet<ZaakTypeTagEntity>

    @ManyToMany
    @JoinTable(
        name = "ztc_zaaktype_zaakstatus", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_zaaktype")],
        inverseJoinColumns = [JoinColumn(name = "id_zaakstatus")]
    )
    lateinit var zaakStatussen: MutableSet<ReferentieZaakStatusEntity>

    @ManyToMany
    @JoinTable(
        name = "ztc_zaaktype_zaaktype", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_zaaktype")],
        inverseJoinColumns = [JoinColumn(name = "id_gekoppeldzaaktype")]
    )
    lateinit var gekoppeldeZaaktypes: MutableSet<ReferentieZaakTypeEntity>

    @OneToMany(mappedBy = "zaakType")
    lateinit var zaakTypeAuthenticaties: MutableSet<ZaakTypeAuthenticatieEntity>

    @OneToMany(mappedBy = "zaakType")
    lateinit var zaakTypeBesluittypen: MutableSet<ZaakTypeBesluittypeEntity>

    @ElementCollection
    @CollectionTable(
        name = "ztc_ref_zaaktype_geautoriseerde_medewerker", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_zaaktype")]
    )
    @Column(name = "medewerker")
    lateinit var geautoriseerdeMedewerkers: MutableSet<String>

    // Of autorisatie op dit element aan of uit staat
    @Column(name = "autorisatie")
    var autorisatie: Boolean = false

    // Starten proces bij aanmaken nieuwe zaak
    @Column(name = "starten_proces")
    var startenProces: Boolean = true

    @OneToMany(mappedBy = "zaakType")
    lateinit var taakDocumentGroepen: MutableSet<ReferentieTaakDocumentGroepEntity>

    // De naam voor het samenvatting document
    @Column(name = "samenvatting_documentnaam", length = 255)
    lateinit var samenvattingDocumentNaam: String

    @OneToMany(mappedBy = "zaakType")
    lateinit var zaakStartParameters: MutableSet<ReferentieZaakStartParameterEntity>

    @Column(name = "productaanvraagtype", length = 255)
    var productaanvraagtype: String? = null

}
