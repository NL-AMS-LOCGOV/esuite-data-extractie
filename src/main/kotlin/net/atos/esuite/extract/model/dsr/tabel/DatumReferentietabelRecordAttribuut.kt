package net.atos.esuite.extract.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class DatumReferentietabelRecordAttribuut(

    @field:Schema(description = "Datum waarde", implementation = LocalDate::class)
    val waarde: LocalDate,

    ) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.datum)



