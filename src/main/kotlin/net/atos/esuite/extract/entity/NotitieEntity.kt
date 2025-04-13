package net.atos.esuite.extract.entity

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "gm_notitie", schema = "basisgegevens")
@AttributeOverride(
    name = "identifier",
    column = Column(name = "id_notitie")
)
class NotitieEntity {

    @Id
    @Column(name = "id_notitie")
    var identifier: Long = 0

    @Column(name = "ingangsdatum")
    var ingangsdatum: LocalDate? = null

    @Column(name = "id_afdeling", length = 128)
    var idAfdeling: String? = null

    @Column(name = "id_groep", length = 128)
    var idGroep: String? = null

    @Column(name = "datumgeldigtot")
    var datumgeldigtot: LocalDate? = null

    @Column(name = "aangemaakt_op")
    lateinit var aangemaaktOp: LocalDate

    @Column(name = "aangemaakt_door", length = 128)
    lateinit var aangemaaktDoor: String

    @Column(name = "titel", length = 128)
    lateinit var titel: String

    @Column(name = "inhoud", length = Int.MAX_VALUE)
    lateinit var inhoud: String

    @ManyToOne
    @JoinColumn(name = "id_subject", referencedColumnName = "id_subject")
    var subject: SubjectEntity? = null
}
