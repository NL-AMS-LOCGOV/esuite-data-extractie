package net.atos.esuite.extract.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class OptiesDataElement(

    @field:Schema(description = "Lijst van opties")
    val waarden: List<String>,

    ) : DataElement(DataElementType.opties)
