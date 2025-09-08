package net.atos.esuite.extract.api.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.math.BigDecimal

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class DecimaalReferentietabelRecordAttribuut(

    @field:Schema(description = "Decimaal waarde")
    val waarde: BigDecimal,

    naam: String,
    omschrijving: String?,
) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.decimaal, naam, omschrijving)



