package net.atos.esuite.extract.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.ZonedDateTime

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class DatumTijdDomeinObjectAttribuutWaarde(

    @field:Schema(description = "Datum/Tijd waarde", implementation = ZonedDateTime::class)
    val waarde: ZonedDateTime,

    ) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.datum_tijd)
