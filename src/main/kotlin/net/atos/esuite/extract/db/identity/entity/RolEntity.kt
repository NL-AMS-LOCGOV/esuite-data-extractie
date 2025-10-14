package net.atos.esuite.extract.db.identity.entity

import jakarta.persistence.*

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
    lateinit var medewerkers: MutableSet<MedewerkerEntity>

    @ManyToMany
    @JoinTable(
        name = "rol_recht", schema = "identity",
        joinColumns = [JoinColumn(name = "id_rol", referencedColumnName = "id_rol")],
        inverseJoinColumns = [JoinColumn(name = "id_recht", referencedColumnName = "id_recht")]
    )
    lateinit var rechten: MutableSet<RechtEntity>
}
