package net.atos.esuite.extract.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class DomeinObjectDomeinObjectAttribuutWaarde (

    @field:Schema(description = "Identificatie van ander domein object binnen hetzelfde domein", required = true)
    val waarde: Long,

    ) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.domein_object)
