package net.atos.esuite.extract.model.document

import net.atos.esuite.extract.model.shared.History
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

@Schema(allOf = [History::class])
class Documenthistorie(
    wijzigingDatum: LocalDate?,
    gewijzigdDoor: String?,
    oudeWaarde: String?,
    nieuweWaarde: String?,
    toelichting: String?,

    @field:Schema(description = "Type wijziging", maxLength = 64)
    val typeWijziging: String?,

    ) : History(
    wijzigingDatum = wijzigingDatum,
    gewijzigdDoor = gewijzigdDoor,
    oudeWaarde = oudeWaarde,
    nieuweWaarde = nieuweWaarde,
    toelichting = toelichting,
)
