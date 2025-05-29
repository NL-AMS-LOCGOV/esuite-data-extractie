package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Recht(

    @field:Schema(description = "Naam van recht", maxLength = 255, uniqueItems = true)
    val naam: String,

    @field:Schema(description = "Is recht actief", required = true)
    val actief: Boolean,

    @field:Schema(description = "Categorie waartoe recht behoort", maxLength = 255)
    val categorie: String,

    @field:Schema(description = "Operatie waarvoor recht gebruikt wordt")
    val operatie: RechtOperatie,

    @field:Schema(description = "Type object waarop operatie van toepassing is")
    val type: RechtType,

    @field:Schema(description = "Waarde van het recht indien flexibel recht")
    val waarde: RechtWaarde?,
)
