package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.time.OffsetDateTime


@Entity
@DiscriminatorValue("DATUMMETTIJDSTIP")
class DatumMetTijdStipDataElementEntity: AbstractDataElementEntity() {

    @Column(name = "calendar_waarde")
    var waarde: OffsetDateTime? = null
}
