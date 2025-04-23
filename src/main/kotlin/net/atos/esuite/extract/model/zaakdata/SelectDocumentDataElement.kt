package net.atos.esuite.extract.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class SelectDocumentDataElement(

    @field:Schema(description = "Lijst van geselecteerde documenten")
    val waarden: List<String>,

    ) : DataElement(DataElementType.select_documents)
