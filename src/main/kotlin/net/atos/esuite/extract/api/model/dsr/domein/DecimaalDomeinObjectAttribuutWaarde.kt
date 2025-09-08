package net.atos.esuite.extract.api.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.math.BigDecimal

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class DecimaalDomeinObjectAttribuutWaarde(

    @field:Schema(description = "Decimaal waarde")
    val waarde: BigDecimal,

    volgnummer: Int,
) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.decimaal, volgnummer)
