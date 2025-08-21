package net.atos.esuite.extract.db.entity.identity

import jakarta.persistence.*
import java.time.Instant
import java.time.LocalDate

@Entity
@Table(name = "medewerker", schema = "identity")
class MedewerkerEntity {

    @Id
    @Column(name = "id_medewerker")
    var identifier: Long = 0

    @OneToOne
    @JoinColumn(name = "id_primaire_afdeling", referencedColumnName = "id_afdeling")
    var primaireAfdeling: AfdelingEntity? = null

    @OneToOne
    @JoinColumn(name = "id_functie", referencedColumnName = "id_functie")
    var functie: FunctieEntity? = null

    // Gebruikersnaam (voor inloggen)
    @Column(name = "medewerkernaam", length = 128, unique = true)
    lateinit var gebruikersnaam: String

    // Volledige naam
    @Column(name = "naam", length = 128)
    lateinit var naam: String

    // Emailadres
    @Column(name = "email", length = 64)
    var email: String? = null

    // Aanduiding wachtwoord wijzigen
    @Column(name = "wijzigenwachtwoord")
    var wijzigenwachtwoord = false

    // Telefoonnummer
    @Column(name = "telefoon", length = 20)
    var telefoon: String? = null

    // geslacht (M of V)
    @Column(name = "geslacht", length = 1)
    lateinit var geslacht: String

    @Column(name = "opmerkingen")
    var opmerkingen: String? = null

    @Column(name = "login_pogingen")
    var loginPogingen: Long = 0

    // Aanduiding gebruiker actief
    @Column(name = "actief")
    var actief = false

    // Aanduiding gebruiker afgesloten
    @Column(name = "afgesloten")
    var afgesloten = false

    @Column(name = "newpasswordrequired")
    var newPasswordRequired = false

    // Laatste logon datum/tijd van de gebruiker
    @Column(name = "laatstelogontijd")
    var laatsteLogonTijd: Instant? = null

    @Column(name = "laatstewachtwoordwijziging")
    var laatsteWachtwoordWijziging: Instant? = null

    // Datum indiensttreding
    @Column(name = "indiensttredingdatum")
    var indiensttredingDatum: LocalDate? = null

    // Datum uitdiensttreding
    @Column(name = "uitdiensttredingdatum")
    var uitdiensttredingDatum: LocalDate? = null

    // Externe naam van de medewerker
    @Column(name = "externenaam", length = 128)
    var externeNaam: String? = null

    @ManyToMany
    @JoinTable(
        name = "medewerker_rol", schema = "identity",
        joinColumns = [JoinColumn(name = "id_medewerker", referencedColumnName = "id_medewerker")],
        inverseJoinColumns = [JoinColumn(name = "id_rol", referencedColumnName = "id_rol")]
    )
    lateinit var rollen: MutableSet<RolEntity>

    @ManyToMany
    @JoinTable(
        name = "medewerker_groep", schema = "identity",
        joinColumns = [JoinColumn(name = "id_medewerker", referencedColumnName = "id_medewerker")],
        inverseJoinColumns = [JoinColumn(name = "id_groep", referencedColumnName = "id_groep")]
    )
    lateinit var groepen: MutableSet<GroepEntity>

    @ManyToMany
    @JoinTable(
        name = "medewerker_afdeling", schema = "identity",
        joinColumns = [JoinColumn(name = "id_medewerker", referencedColumnName = "id_medewerker")],
        inverseJoinColumns = [JoinColumn(name = "id_afdeling", referencedColumnName = "id_afdeling")]
    )
    lateinit var afdelingen: MutableSet<AfdelingEntity>
}
