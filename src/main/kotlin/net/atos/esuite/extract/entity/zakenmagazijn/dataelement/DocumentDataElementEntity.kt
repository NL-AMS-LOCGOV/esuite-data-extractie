package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.*


@Entity
@DiscriminatorValue("ZAAK_DOCUMENTEN")
class DocumentDataElementEntity: AbstractDataElementEntity() {

    @ElementCollection
    @JoinTable(
        name = "zkn_zaak_dataelement_documentwaardes", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_dataelement", referencedColumnName = "id_dataelement")]
    )
    lateinit var documentEntities: List<DocumentItemEntity>
}
