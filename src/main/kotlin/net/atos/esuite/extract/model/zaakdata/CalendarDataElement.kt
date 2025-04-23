package net.atos.esuite.extract.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.ZonedDateTime

@Schema(allOf = [DataElement::class])
class CalendarDataElement(
    type: DataElementType,

    @field:Schema(description = "Calendar waarde data element", implementation = ZonedDateTime::class)
    val waarde: ZonedDateTime?,

    ) : DataElement(type)
