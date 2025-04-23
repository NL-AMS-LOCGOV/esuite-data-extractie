package net.atos.esuite.extract.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class BooleanDataElement(

    @field:Schema(description = "Boolean waarde data element")
    val waarde: Boolean?,

    ) : DataElement(DataElementType.boolean)
