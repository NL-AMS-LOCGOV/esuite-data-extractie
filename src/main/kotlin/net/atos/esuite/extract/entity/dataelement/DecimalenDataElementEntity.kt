package net.atos.esuite.extract.entity.dataelement

import jakarta.persistence.*
import java.math.BigDecimal


@Entity
@DiscriminatorValue("DECIMALEN")
class DecimalenDataElementEntity: AbstractDataElementEntity() {

    @ElementCollection
    @CollectionTable(
        name = "zkn_zaak_dataelement_nummerwaardes", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_dataelement", referencedColumnName = "id_dataelement")]
    )
    var waarde: MutableSet<BigDecimal> = mutableSetOf()
}
