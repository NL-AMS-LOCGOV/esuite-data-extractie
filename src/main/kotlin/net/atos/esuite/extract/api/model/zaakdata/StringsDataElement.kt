package net.atos.esuite.extract.api.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class StringsDataElement(

    @field:Schema(description = "Lijst van string waarden")
    val waarden: List<String>,

    ) : DataElement(DataElementType.strings)
