package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("DIGITALE_NOTIFICATIES")
class ToestemmingDigitaleNotificatiesDataElementEntity: net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractComplexDataElementEntity() {
}
