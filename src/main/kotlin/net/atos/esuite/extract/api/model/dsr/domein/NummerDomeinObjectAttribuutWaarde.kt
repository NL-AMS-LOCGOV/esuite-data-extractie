package net.atos.esuite.extract.api.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class NummerDomeinObjectAttribuutWaarde(

    @field:Schema(description = "Integer waarde", required = true)
    val waarde: Long,

    volgnummer: Int,
) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.nummer, volgnummer)
