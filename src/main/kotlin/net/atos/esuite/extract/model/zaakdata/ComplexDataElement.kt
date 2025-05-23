package net.atos.esuite.extract.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class ComplexDataElement(
    type: DataElementType,

    @field:Schema(description = "Complexe waarde data element")
    val waarde: String?,

    ) : DataElement(type)
