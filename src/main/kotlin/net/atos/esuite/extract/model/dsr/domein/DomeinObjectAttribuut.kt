package net.atos.esuite.extract.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema

class DomeinObjectAttribuut (

    @field:Schema(description = "Naam van domein object attribuut", maxLength = 128)
    val naam: String,

    @field:Schema(description = "Omschrijving van domein object attribuut")
    val omschrijving: String?,

    @field:Schema(description = "Waarden van domein object attribuut")
    val waarden: List<DomeinObjectAttribuutWaarde>,
)
