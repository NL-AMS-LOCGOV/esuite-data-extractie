package net.atos.esuite.extract.api.model.zaaktype

import net.atos.esuite.extract.api.model.zaak.BewaartermijnWaardering
import net.atos.esuite.extract.api.model.zaak.Resultaat
import org.eclipse.microprofile.openapi.annotations.media.Schema

class ZaaktypeResultaat(

    @field:Schema(description = "Resultaat van zaak")
    val resultaat: Resultaat,

    @field:Schema(description = "Selectielijst item")
    val selectielijstitem: Selectielijstitem,

    @field:Schema(description = "Waardering van de bewaartermijn")
    val bewaartermijnWaardering: BewaartermijnWaardering?,

    @field:Schema(description = "Bewaartermijn. Voor eenheid zie bewaartermijnEenheid")
    val bewaartermijn: Int?,

    @field:Schema(description = "Bewaartermijn eenheid")
    val bewaartermijnEenheid: BewaartermijnEenheid?,
)
