package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.*
import net.atos.esuite.extract.entity.zakenmagazijn.ZaakEntity


@Entity
@Inheritance
@Table(name = "zkn_zaak_dataelement", schema = "zakenmagazijn")
open class AbstractDataElementEntity {

    @Id
    @Column(name = "id_dataelement")
    var id: Long = 0

    // De sleutel van de key,value pair
    @Column(name = "sleutel", length = 255)
    lateinit var sleutel: String

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity

    // Bevat een omschrijving of verklarende waarde voor het data element
    @Column(name = "omschrijving", length = Int.MAX_VALUE)
    var omschrijving: String? = null
}
