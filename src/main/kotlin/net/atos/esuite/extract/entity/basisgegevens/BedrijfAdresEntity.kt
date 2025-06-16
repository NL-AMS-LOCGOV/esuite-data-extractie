package net.atos.esuite.extract.entity.basisgegevens

import jakarta.persistence.*

@Entity
@Table(name = "gm_bedrijfadres", schema = "basisgegevens")
class BedrijfAdresEntity : AbstractSubjectAdresEntity() {

    @Id
    @Column(name = "id_bedrijfadres")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_bedrijf", referencedColumnName = "id_bedrijf")
    lateinit var bedrijf: BedrijfEntity
}
