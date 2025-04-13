package net.atos.esuite.extract.entity.zakenmagazijn.dataelement

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.time.OffsetDateTime


@Entity
@DiscriminatorValue("CALENDAR")
class CalendarDataElementEntity: net.atos.esuite.extract.entity.zakenmagazijn.dataelement.AbstractDataElementEntity() {

    @Column(name = "calendar_waarde")
    var waarde: OffsetDateTime? = null
}
