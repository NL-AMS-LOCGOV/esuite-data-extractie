package net.atos.esuite.extract.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class StringDataElement(

    @field:Schema(description = "String waarde data element")
    val waarde: String?,

    ) : DataElement(DataElementType.string)
