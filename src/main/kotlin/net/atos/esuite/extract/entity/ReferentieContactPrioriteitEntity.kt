package net.atos.esuite.extract.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "con_ref_contactprioriteit", schema = "contactenmagazijn")
class ReferentieContactPrioriteitEntity: AbstractReferentieLongIdEntity() {

    @Id
    @Column(name = "id_contactprioriteit")
    lateinit var identifier: java.lang.Long

    @Column(name = "dagen")
    lateinit var dagen: java.lang.Integer
}
