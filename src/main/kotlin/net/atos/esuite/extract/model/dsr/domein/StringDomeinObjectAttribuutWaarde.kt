package net.atos.esuite.extract.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class StringDomeinObjectAttribuutWaarde(

    @field:Schema(description = "String waarde")
    val waarde: String,

    ) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.string)
