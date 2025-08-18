package net.atos.esuite.extract.entity.basisgegevens

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.PrimaryKeyJoinColumn
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "gm_personen", schema = "basisgegevens" )
@PrimaryKeyJoinColumn(name = "id_persoon", referencedColumnName = "id_subject")
class PersoonEntity: SubjectEntity() {

    @Column(name = "voornamen", length = 200)
    var voornamen: String? = null

    @Column(name = "voorletters", length = 20)
    var voorletters: String? = null

    @Column(name = "geslachtsnaam", length = 200)
    var geslachtsNaam: String? = null

    @Column(name = "voorvoegsel", length = 10)
    var voorvoegsel: String? = null

    // Geslachtsaanduiding (O,M,V)
    @Column(name = "geslachtsaanduiding", length = 1)
    var geslachtsAanduiding: String? = null

    // Aanhef van de aanschrijving
    @Column(name = "aanhefaanschrijving", length = 64)
    var aanhefAanschrijving: String? = null

    @Column(name = "titel_adelijk", length = 10)
    var titelAdelijk: String? = null

    @Column(name = "titel_pre_academisch", length = 20)
    var titelPreAcademisch: String? = null

    @Column(name = "titel_post_academisch", length = 20)
    var titelPostAcademisch: String? = null

    // Aanduiding van het naamgebruik (E, N, P, V)
    @Column(name = "aanduidingnaamgebruik", length = 1)
    var aanduidingNaamGebruik: String? = null

    @Column(name = "geslachtsnaam_partner", length = 200)
    var geslachtsNaamPartner: String? = null

    @Column(name = "voorvoegsel_partner", length = 10)
    var voorvoegselPartner: String? = null

    @Column(name = "geboortedatum")
    var geboortedatum: LocalDate? = null

    @Column(name = "geboorteplaats", length = 255)
    var geboorteplaats: String? = null

    @Column(name = "overlijdendatum")
    var overlijdensdatum: LocalDate? = null

    @Column(name = "overlijdenplaats", length = 255)
    var overlijdensplaats: String? = null

    @Column(name = "anummer", length = 10)
    var aNummer: String? = null

    @Column(name = "burgerservicenummer", length = 9)
    var burgerServiceNummer: String? = null

    @Column(name = "emailadres", length = 255)
    var emailadres: String? = null

    @Column(name = "ontvangen_zaak_notificaties")
    var ontvangenZaakNotificaties: Boolean? = null

    @Column(name = "telefoonnummer", length = 20)
    var telefoonnummer: String? = null

    @Column(name = "telefoonnummer_alternatief", length = 20)
    var telefoonnummerAlternatief: String? = null

    @Column(name = "rekeningnummer", length = 64)
    var rekeningnummer: String? = null

    // Reden opschorting bijhouding adresgegevens ('.', O,E,M,F)
    @Column(name = "redenopschorting", length = 10)
    var redenOpschorting: String? = null

    @Column(name = "datumopschorting")
    var datumOpschorting: LocalDate? = null

    @Column(name = "ind_blokkering")
    var indicatieGeblokkeerd = false

    @Column(name = "ind_curateleregister")
    var indicatieCurateleRegister = false

    @Column(name = "ind_inonderzoek")
    var indicatieInOnderzoek = false

    @Column(name = "ind_onvolledige_gebdatum")
    @Enumerated(EnumType.STRING)
    var indicatieOnvolledigeGeboortedatum: OnvolledigeDatumIndicatieType? = null

    @Column(name = "ind_onvolledige_overldatum")
    @Enumerated(EnumType.STRING)
    var indicatieOnvolledigeOverlijdensdatum: OnvolledigeDatumIndicatieType? = null

    @Column(name = "ind_beperking_verstrekking")
    var indicatieBeperkingVerstrekking = false

    // Indicatie niet-ingezetene (I,N,A)
    @Column(name = "ind_nietingezetene", length = 1)
    var indicatieNietIngezetene: String? = null

    @Column(name = "ind_handmatigtoegevoegd")
    var indicatieHandmatigToegevoegd = false

    @Column(name = "ind_afnemer")
            var indicatieAfnemer = false

    @Column(name = "anp_identificatie", length = 19)
    var anpIdentificatie: Long? = null

    @Column(name = "gemeentecode", length = 10)
    var gemeentecode: String? = null

    @Column(name = "toestemmingZaakNotificatiesAlleenDigitaal")
    var toestemmingZaakNotificatiesAlleenDigitaal: Boolean? = null

    @ManyToOne
    @JoinColumn(name = "id_geboorteland", referencedColumnName = "gbacode")
    var geboorteland: ReferentieLandEntity? = null

    @ManyToOne
    @JoinColumn(name = "id_overlijdenland", referencedColumnName = "gbacode")
    var overlijdensland: ReferentieLandEntity? = null

    @ManyToOne
    @JoinColumn(name = "id_burgerlijkestaat", referencedColumnName = "gbacode")
    lateinit var burgerlijkestaat: ReferentieBurgerlijkeStaatEntity

    @OneToMany(mappedBy = "persoon")
    lateinit var  adressen: MutableSet<PersoonAdresEntity>

    @OneToMany(mappedBy = "persoon")
    lateinit var nationaliteiten: MutableSet<PersoonNationaliteitEntity>

    @OneToMany(mappedBy = "persoon")
    lateinit var reisdocumenten: MutableSet<PersoonReisdocumentEntity>

    @OneToMany(mappedBy = "persoon")
    lateinit var relaties: MutableSet<RelatieEntity>
}
