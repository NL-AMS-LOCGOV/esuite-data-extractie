package net.atos.esuite.extract.entity.identity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "rol", schema = "identity")
class RolEntity {

    @Id
    @Column(name = "id_rol")
    var identifier: Long = 0

    // Naam van rol
    @Column(name = "naam", length = 128)
    lateinit var naam: String

    // Omschrijving van rol
    @Column(name = "omschrijving")
    lateinit var omschrijving: String

    // Aanduiding rol actief
    @Column(name = "actief")
    var actief = false

    @ManyToMany(mappedBy = "rollen")
    val medewerkers: MutableSet<MedewerkerEntity> = mutableSetOf()

    @ManyToMany
    @JoinTable(
        name = "rol_recht", schema = "identity",
        joinColumns = [JoinColumn(name = "id_rol", referencedColumnName = "id_rol")],
        inverseJoinColumns = [JoinColumn(name = "id_recht", referencedColumnName = "id_recht")]
    )
    val rechten: MutableSet<RechtEntity> = mutableSetOf()
}
