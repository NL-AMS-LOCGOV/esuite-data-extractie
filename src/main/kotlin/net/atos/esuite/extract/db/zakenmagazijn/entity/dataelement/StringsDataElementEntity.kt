package net.atos.esuite.extract.db.zakenmagazijn.entity.dataelement

import jakarta.persistence.*


@Entity
@DiscriminatorValue("STRINGS")
class StringsDataElementEntity: AbstractDataElementEntity() {

    @ElementCollection
    @CollectionTable(
        name = "zkn_zaak_dataelement_stringwaardes", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_dataelement", referencedColumnName = "id_dataelement")]
    )
    lateinit var waarde: List<String>
}
