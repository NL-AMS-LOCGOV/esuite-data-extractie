package net.atos.esuite.extract.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "con_ref_contacttype", schema = "contactenmagazijn")
class ReferentieContactTypeEntity: AbstractReferentieLongIdEntity() {

    @Id
    @Column(name = "id_contacttype")
    lateinit var identifier: java.lang.Long

}
