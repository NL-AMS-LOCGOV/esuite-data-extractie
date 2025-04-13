package net.atos.esuite.extract.entity

import jakarta.persistence.*

@Entity
@Table(name = "gm_subject", schema = "basisgegevens")
@Inheritance(strategy = InheritanceType.JOINED)
class SubjectEntity {
    
    @Id
    @Column(name = "id_subject")
    var identifier: Long = 0

    @OneToMany(mappedBy = "subject")
    var notities: MutableList<NotitieEntity> = mutableListOf()
}
