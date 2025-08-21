package net.atos.esuite.extract.api.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class BooleanReferentietabelRecordAttribuut(

    @field:Schema(description = "Boolean waarde", required = true)
    val waarde: Boolean,

    ) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.boolean)



