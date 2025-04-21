package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class MetadataElement(
    naam: String,
    omschrijving: String?,

    @field:Schema(description = "Label van metadata element", maxLength = 255)
    val label: String,

    @field:Schema(description = "Type van metadata element")
    val type: DocumentMetadataElementType,

    @field:Schema(description = "Indicatie is verplicht element", required = true)
    val indicatieVerplicht: Boolean,

    @field:Schema(description = "Indicatie of het metadata element gebruikt wordt bij alle documenttypes", required = true)
    val indicatieVoorAlleDocumenttypes: Boolean,

    ) : AbstractReferentie(
    naam = naam,
    omschrijving = omschrijving
)
