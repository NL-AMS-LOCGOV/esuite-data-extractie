package net.atos.esuite.extract.api.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class BooleanDomeinObjectAttribuutWaarde(

    @field:Schema(description = "Boolean waarde", required = true)
    val waarde: Boolean,

    volgnummer: Int,
) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.boolean, volgnummer)
