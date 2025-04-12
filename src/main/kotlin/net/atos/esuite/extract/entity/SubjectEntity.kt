package net.atos.esuite.extract.entity

import jakarta.persistence.*

@Entity
@Table(name = "gm_subject", schema = "basisgegevens")
@Inheritance(strategy = InheritanceType.JOINED)
class SubjectEntity {
    
    @Id
    @Column(name = "id_subject")
    lateinit var identifier: java.lang.Long

    @OneToMany(mappedBy = "subject")
    var notities: MutableList<NotitieEntity> = mutableListOf()
}
