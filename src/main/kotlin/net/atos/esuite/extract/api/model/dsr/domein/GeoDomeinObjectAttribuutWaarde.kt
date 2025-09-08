package net.atos.esuite.extract.api.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class GeoDomeinObjectAttribuutWaarde(

    @field:Schema(description = "Well-known text geografische informatie")
    val waarde: String,

    volgnummer: Int,
) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.geo, volgnummer)
