package net.atos.esuite.extract.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate
import java.time.LocalDateTime

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class DatumReferentietabelRecordAttribuut(
    
    @field:Schema(description = "Datum waarde", implementation = LocalDateTime::class)
    val waarde: LocalDate,

) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.datum)



