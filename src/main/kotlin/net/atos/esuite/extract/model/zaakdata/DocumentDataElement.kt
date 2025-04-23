package net.atos.esuite.extract.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class DocumentDataElement(

    @field:Schema(description = "Lijst van zaak document bestandsnamen")
    val waarden: List<String>,

    ) : DataElement(DataElementType.zaak_documenten)
