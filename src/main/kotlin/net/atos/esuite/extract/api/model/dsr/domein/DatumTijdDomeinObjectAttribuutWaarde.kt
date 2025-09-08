package net.atos.esuite.extract.api.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.ZonedDateTime

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class DatumTijdDomeinObjectAttribuutWaarde(

    @field:Schema(description = "Datum/Tijd waarde", implementation = ZonedDateTime::class)
    val waarde: ZonedDateTime,

    volgnummer: Int,
) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.datum_tijd, volgnummer)
