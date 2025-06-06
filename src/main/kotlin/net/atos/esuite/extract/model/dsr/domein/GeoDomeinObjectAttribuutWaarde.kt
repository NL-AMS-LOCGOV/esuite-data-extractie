package net.atos.esuite.extract.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class GeoDomeinObjectAttribuutWaarde(

    @field:Schema(description = "Well-known text geografische informatie")
    val waarde: String,

    ) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.geo)
