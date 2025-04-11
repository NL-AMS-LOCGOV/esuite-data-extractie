package net.atos.esuite.extract.entity

import jakarta.persistence.*


@Entity
@Inheritance
@Table(name = "zkn_zaak_dataelement", schema = "zakenmagazijn")
class AbstractDataElementEntity {

    @Id
    @Column(name = "id_dataelement")
    lateinit var id: java.lang.Long

    // ToDo: aanvullen
}
