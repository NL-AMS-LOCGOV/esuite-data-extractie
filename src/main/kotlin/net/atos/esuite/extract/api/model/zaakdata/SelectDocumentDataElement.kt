package net.atos.esuite.extract.api.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class SelectDocumentDataElement(

    @field:Schema(description = "Lijst van geselecteerde documenten")
    val waarden: List<String>,

    naam: String,
    omschrijving: String?
) : DataElement(DataElementType.select_documents, naam, omschrijving)
