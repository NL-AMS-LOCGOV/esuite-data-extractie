package net.atos.esuite.extract.db.basisgegevens.entity

import jakarta.persistence.*

@Entity
@Table(name = "gm_persoonadres", schema = "basisgegevens")
@AttributeOverride(name = "identifier", column = Column(name = "id_persoonadres"))
class PersoonAdresEntity : AbstractSubjectAdresEntity() {

    @Id
    @Column(name = "id_persoonadres")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_persoon", referencedColumnName = "id_persoon")
    lateinit var persoon: PersoonEntity
}
