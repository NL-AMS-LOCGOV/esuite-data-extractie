package net.atos.esuite.extract.model.document

import net.atos.esuite.extract.model.document.MetadataElement
import org.eclipse.microprofile.openapi.annotations.media.Schema

class DocumentMetadata(
    @field:Schema(description = "ID van metadata element")
    val metadataElement: MetadataElement?,

    @field:Schema(description = "Waarde van metadata element")
    val waarde: String?,
)
