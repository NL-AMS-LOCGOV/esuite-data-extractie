package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.*


@Entity
@DiscriminatorValue("OPTIES")
class OptiesDataElementEntity: net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractDataElementEntity() {

    @ElementCollection
    @CollectionTable(
        name = "zkn_zaak_dataelement_optiewaardes", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_dataelement", referencedColumnName = "id_dataelement")]
    )
    @Column(name = "gemarshallde_optie_waarde")
    var gemarshalldeOptieWaarde: MutableList<String> = mutableListOf()
}
