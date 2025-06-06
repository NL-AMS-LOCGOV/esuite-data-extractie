package net.atos.esuite.extract.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class NummerReferentietabelRecordAttribuut(

    @field:Schema(description = "Integer waarde", required = true)
    val waarde: Long,

    ) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.nummer)



