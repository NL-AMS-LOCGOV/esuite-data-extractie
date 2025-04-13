package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.*


@Entity
@DiscriminatorValue("ZAAK_DOCUMENTEN")
class DocumentDataElementEntity: net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractDataElementEntity() {

    @ElementCollection
    @JoinTable(
        name = "zkn_zaak_dataelement_documentwaardes", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_dataelement", referencedColumnName = "id_dataelement")]
    )
    var documentEntities: MutableList<net.atos.esuite.extract.entity.zakenmagazijn.dataelement.DocumentItemEntity> = mutableListOf()
}
