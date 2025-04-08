package net.atos.esuite.extract.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Comment

@Entity
@Table(name = "zkn_taak", schema = "zakenmagazijn")
class TaakEntity {

    @Id
    @Comment("ID-nummer tabel Zaak")
    @Column(name = "id_taak")
    lateinit var identifier: java.lang.Long
}
