package net.atos.esuite.extract.entity.identity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "afdeling", schema = "identity")
class AfdelingEntity {

    @Id
    @Column(name = "id_afdeling")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_afdelingshoofd")
    var afdelingshoofd: MedewerkerEntity? = null

    // Naam van afdeling
    @Column(name = "naam", length = 128)
    lateinit var naam: String

    // Omschrijving van afdeling
    @Column(name = "omschrijving")
    lateinit var omschrijving: String

    // Interne code van afdeling
    @Column(name = "code", length = 128, unique = true)
    var code: String? = null

    // Aanduiding afdeling actief
    @Column(name = "actief")
    var actief = false

    // Emailadres
    @Column(name = "email", length = 64)
    var email: String? = null

    @ManyToMany(mappedBy = "afdelingen")
    lateinit var medewerkers: MutableSet<MedewerkerEntity>
}
