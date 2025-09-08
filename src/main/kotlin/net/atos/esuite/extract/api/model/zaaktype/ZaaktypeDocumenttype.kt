package net.atos.esuite.extract.api.model.zaaktype

import net.atos.esuite.extract.api.model.document.DocumentTitel
import net.atos.esuite.extract.api.model.document.Documenttype
import org.eclipse.microprofile.openapi.annotations.media.Schema

class ZaaktypeDocumenttype(

    @field:Schema(description = "Type document")
    val documenttype: Documenttype,

    @field:Schema(description = "DSP code", maxLength = 255)
    val dspcode: String?,

    @field:Schema(description = "Mogelijke voorgedefinieerde document titels")
    val titels: List<DocumentTitel>?,
)
