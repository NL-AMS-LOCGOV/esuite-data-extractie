package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

// Specifiek DataElement entity voor de opslag van een verwijzing naar een ReferentietabelRecord
@Entity
@DiscriminatorValue("REFERENTIETABEL_RECORD")
class ReferentietabelRecordItemDataElementEntity: net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractComplexDataElementEntity() {
}
