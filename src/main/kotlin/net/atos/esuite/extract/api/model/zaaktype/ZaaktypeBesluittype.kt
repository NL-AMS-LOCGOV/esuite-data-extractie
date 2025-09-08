package net.atos.esuite.extract.api.model.zaaktype

import net.atos.esuite.extract.api.model.besluit.Besluittype
import net.atos.esuite.extract.api.model.document.Documenttype
import org.eclipse.microprofile.openapi.annotations.media.Schema

class ZaaktypeBesluittype(

    @field:Schema(description = "Type besluit")
    val besluittype: Besluittype,

    @field:Schema(description = "Documenttype van document met besluit")
    val documenttype: Documenttype?,

    @field:Schema(description = "Procestermijn in maanden")
    val procestermijn: Int?,
)
