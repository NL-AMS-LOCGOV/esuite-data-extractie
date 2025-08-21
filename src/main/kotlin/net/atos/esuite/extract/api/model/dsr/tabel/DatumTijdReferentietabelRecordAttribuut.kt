package net.atos.esuite.extract.api.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.ZonedDateTime

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class DatumTijdReferentietabelRecordAttribuut(

    @field:Schema(description = "Datum/Tijd waarde", implementation = ZonedDateTime::class)
    val waarde: ZonedDateTime,

    ) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.datum_tijd)



