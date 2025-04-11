package net.atos.esuite.extract.entity.dataelement

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("DIGITALE_NOTIFICATIES")
class ToestemmingDigitaleNotificatiesDataElementEntity: AbstractComplexDataElementEntity() {
}
