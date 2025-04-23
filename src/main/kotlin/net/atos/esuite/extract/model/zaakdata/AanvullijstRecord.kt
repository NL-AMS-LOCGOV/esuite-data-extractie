package net.atos.esuite.extract.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

class AanvullijstRecord(
    @field:Schema(description = "Record nummer")
    val recordNummer: Int,

    @field:Schema(description = "Item identificatie")
    val itemIdentificatie: String,

    @field:Schema(description = "Item waarde")
    val itemWaarde: String?,
)
