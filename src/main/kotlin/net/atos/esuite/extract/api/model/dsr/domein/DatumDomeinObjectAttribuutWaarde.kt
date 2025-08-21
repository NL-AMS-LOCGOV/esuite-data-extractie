package net.atos.esuite.extract.api.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class DatumDomeinObjectAttribuutWaarde(

    @field:Schema(description = "Datum waarde", implementation = LocalDate::class)
    val waarde: LocalDate,

    ) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.datum)
