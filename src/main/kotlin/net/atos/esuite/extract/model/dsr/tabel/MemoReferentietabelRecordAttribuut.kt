package net.atos.esuite.extract.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class MemoReferentietabelRecordAttribuut(
    
    @field:Schema(description = "Text waarde")
    val waarde: String,

) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.memo)



