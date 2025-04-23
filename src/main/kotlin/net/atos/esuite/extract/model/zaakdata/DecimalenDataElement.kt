package net.atos.esuite.extract.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.math.BigDecimal

@Schema(allOf = [DataElement::class])
class DecimalenDataElement(

    @field:Schema(description = "Lijst van decimalen")
    val waarden: Set<BigDecimal>?,

    ) : DataElement(DataElementType.decimalen)
