package net.atos.esuite.extract.api.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.math.BigDecimal

@Schema(allOf = [DataElement::class])
class DecimaalDataElement(

    @field:Schema(description = "Decimaal waarde data element")
    val waarde: BigDecimal?,

    @field:Schema(description = "Manier waarop nummer geformatteerd moet worden")
    val formattering: NummerFormattering?,

    ) : DataElement(DataElementType.decimaal)
