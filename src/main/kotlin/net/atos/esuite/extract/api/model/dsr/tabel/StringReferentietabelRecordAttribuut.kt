package net.atos.esuite.extract.api.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class StringReferentietabelRecordAttribuut(

    @field:Schema(description = "String waarde")
    val waarde: String,

    ) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.string)



