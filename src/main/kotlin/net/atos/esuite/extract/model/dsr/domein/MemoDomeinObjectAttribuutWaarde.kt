package net.atos.esuite.extract.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class MemoDomeinObjectAttribuutWaarde(

    @field:Schema(description = "Text waarde")
    val waarde: String,

    ) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.memo)
