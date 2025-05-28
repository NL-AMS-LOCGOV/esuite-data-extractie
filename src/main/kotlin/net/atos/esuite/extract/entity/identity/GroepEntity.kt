package net.atos.esuite.extract.entity.identity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

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

    @ManyToMany(mappedBy = "groepen", fetch = FetchType.LAZY)
    var medewerkers: MutableSet<MedewerkerEntity?>? = null

}
