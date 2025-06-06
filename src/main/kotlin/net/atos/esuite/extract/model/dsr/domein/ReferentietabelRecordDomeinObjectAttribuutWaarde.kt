package net.atos.esuite.extract.model.dsr.domein

import net.atos.esuite.extract.model.dsr.tabel.ReferentietabelRecord
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DomeinObjectAttribuutWaarde::class])
class ReferentietabelRecordDomeinObjectAttribuutWaarde(

    @field:Schema(description = "Referentietabel record")
    val waarde: ReferentietabelRecord,

    ) : DomeinObjectAttribuutWaarde(DomeinObjectAttribuutWaardeType.referentietabel_record)
