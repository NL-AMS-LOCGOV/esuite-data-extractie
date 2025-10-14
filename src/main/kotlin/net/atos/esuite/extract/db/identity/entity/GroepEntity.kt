package net.atos.esuite.extract.db.identity.entity

import jakarta.persistence.*

@Entity
@Table(name = "groep", schema = "identity")
class GroepEntity {

    @Id
    @Column(name = "id_groep")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_groepshoofd")
    var groepshoofd: MedewerkerEntity? = null

    // Naam van groep
    @Column(name = "naam", length = 128)
    lateinit var naam: String

    // Omschrijving van groep
    @Column(name = "omschrijving")
    lateinit var omschrijving: String

    // Interne code van groep
    @Column(name = "code", length = 128, unique = true)
    var code: String? = null

    // Aanduiding groep actief
    @Column(name = "actief")
    var actief = false

    // Emailadres
    @Column(name = "email", length = 64)
    var email: String? = null

    @ManyToMany(mappedBy = "groepen")
    lateinit var medewerkers: MutableSet<MedewerkerEntity>
}
