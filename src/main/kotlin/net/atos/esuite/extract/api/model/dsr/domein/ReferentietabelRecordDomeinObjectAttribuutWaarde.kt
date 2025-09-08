package net.atos.esuite.extract.api.model.dsr.domein

import net.atos.esuite.extract.api.model.dsr.tabel.ReferentietabelRecord
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class ReferentietabelRecordDomeinObjectAttribuutWaarde(

    @field:Schema(description = "Referentietabel record")
    val waarde: ReferentietabelRecord,

    volgnummer: Int,
) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.referentietabel_record, volgnummer)
