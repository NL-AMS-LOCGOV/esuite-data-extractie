package net.atos.esuite.extract.db.zakenmagazijn.entity.dataelement

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("ZAAK_BESLUIT")
class ZaakBesluitItemDataElementEntity: AbstractComplexDataElementEntity() {
}
