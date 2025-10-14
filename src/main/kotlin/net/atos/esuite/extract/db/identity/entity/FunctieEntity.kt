package net.atos.esuite.extract.db.identity.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "functie", schema = "identity")
class FunctieEntity {

    @Id
    @Column(name = "id_functie")
    var identifier: Long = 0

    // Naam van functie
    @Column(name = "naam", length = 128)
    lateinit var naam: String

    // Omschrijving van functie
    @Column(name = "omschrijving")
    lateinit var omschrijving: String

    // Aanduiding functie in gebruik
    @Column(name = "actief")
    var actief = false
}
