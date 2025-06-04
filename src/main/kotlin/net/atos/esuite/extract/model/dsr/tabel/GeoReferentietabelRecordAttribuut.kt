package net.atos.esuite.extract.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class GeoReferentietabelRecordAttribuut(
    
    @field:Schema(description = "Well-known text geografische informatie")
    val waarde: String,

) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.geo)



