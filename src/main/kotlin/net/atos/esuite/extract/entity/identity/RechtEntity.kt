package net.atos.esuite.extract.entity.identity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "recht", schema = "identity")
class RechtEntity {

    @Id
    @Column(name = "id_recht")
    var identifier: Long = 0

    // Naam van recht
    @Column(name = "naam", length = 255, unique = true)
    lateinit var naam: String

    // Aanduiding recht actief
    @Column(name = "actief")
    var actief = false

    // Operatie waarvoor recht gebruikt wordt
    @Column(name = "operatie", length = 255)
    lateinit var operatie: String

    // Type object waarop operatie van toepassing is
    @Column(name = "type", length = 255)
    lateinit var type: String

    // Waarde van het recht indien flexibel recht voor zaak of afdeling
    @Column(name = "waarde", length = 255)
    var waarde: String? = null

    // Categorie waartoe recht behoort
    @Column(name = "categorie", length = 255)
    lateinit var categorie: String
}
