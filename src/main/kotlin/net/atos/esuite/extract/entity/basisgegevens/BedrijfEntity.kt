package net.atos.esuite.extract.entity.basisgegevens

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.PrimaryKeyJoinColumn
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "gm_bedrijf", schema = "basisgegevens")
@PrimaryKeyJoinColumn(name = "id_bedrijf", referencedColumnName = "id_subject")
class BedrijfEntity : SubjectEntity() {

    @Column(name = "kvknummer", length = 8)
    var kvknummer: String? = null

    @Column(name = "vestigingsnummer", length = 12)
    var vestigingsnummer: String? = null

    @Column(name = "buitenlandshandelsregisternummer", length = 255)
    var buitenlandsHandelsregisternummer: String? = null

    @Column(name = "bedrijfsnaam", length = 128)
    var bedrijfsnaam: String? = null

    @Column(name = "vennootschapsnaam", length = 255)
    var vennootschapsnaam: String? = null

    @Column(name = "statutairezetel", length = 64)
    var statutaireZetel: String? = null

    @Column(name = "datumvestiging")
    var datumVestiging: LocalDate? = null

    @Column(name = "datumopheffing")
    var datumOpheffing: LocalDate? = null

    @Column(name = "datumvoortzetting")
    var datumVoortzetting: LocalDate? = null

    @Column(name = "telefoon", length = 20)
    var telefoon: String? = null

    @Column(name = "telefoonnummer_alternatief", length = 20)
    var telefoonnummerAlternatief: String? = null

    @Column(name = "telefax", length = 20)
    var telefax: String? = null

    @Column(name = "emailadres", length = 128)
    var emailadres: String? = null

    @Column(name = "ontvangen_zaak_notificaties")
    var ontvangenZaakNotificaties: Boolean? = null

    @Column(name = "bankrekening", length = 64)
    var bankrekening: String? = null

    @Column(name = "aantalwerknemers")
    var aantalWerknemers: Int? = null

    @Column(name = "ind_surseance")
    var indSurseance = false

    @Column(name = "ind_faillisement")
    var indFaillisement = false

    @Column(name = "ind_handmatigtoegevoegd")
    var indicatieHandmatigToegevoegd = false

    @Column(name = "rsinummer", length = 20)
    var rsinummer: String? = null

    @Column(name = "statusvestiging", length = 1)
    var statusVestiging: String? = null

    @Column(name = "finummereigenaar", length = 20)
    var fiNummerEigenaar: String? = null

    @Column(name = "ingangsdatum")
    lateinit var ingangsdatum: LocalDate

    @Column(name = "ind_hoofdvestiging")
    var indHoofdVestiging: Boolean? = null

    @Column(name = "toestemmingZaakNotificatiesAlleenDigitaal")
    var toestemmingZaakNotificatiesAlleenDigitaal = false

    // ToDo: 
//    @ManyToOne
//    @JoinColumn(name = "id_hoofdactiviteit", referencedColumnName = "id_hoofdactiviteit")
//    var hoofdactiviteit: ReferentieHoofdactiviteitEntity? = null
//
//    @ManyToOne
//    @JoinColumn(name = "id_rechtsvorm", referencedColumnName = "id_rechtsvorm")
//    var rechtsvorm: ReferentieRechtsvormEntity? = null
//
//    @OneToMany(mappedBy = "bedrijf")
//    var adressen: MutableSet<BedrijfAdresEntity> = mutableSetOf()
//
//    @ManyToMany
//    @JoinTable(
//        name = "gm_bedrijfnevenactiviteit", schema = "basisgegevens",
//        joinColumns = [JoinColumn(name = "id_bedrijf")],
//        inverseJoinColumns = [JoinColumn(name = "id_nevenactiviteit")]
//    )
//    var nevenactiviteiten: MutableSet<ReferentieNevenactiviteitEntity> = mutableSetOf()
//
//    @OneToMany(mappedBy = "bedrijf")
//    var contactpersonen: MutableSet<ContactpersoonEntity> = mutableSetOf()
}
