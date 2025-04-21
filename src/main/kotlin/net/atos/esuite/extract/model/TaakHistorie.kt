package net.atos.esuite.extract.model

import net.atos.esuite.extract.entity.shared.AbstractHistoryEntity
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class TaakHistorie(
    wijzigingDatum: LocalDate?,
    gewijzigdDoor: String?,
    oudeWaarde: String?,
    nieuweWaarde: String?,
    toelichting: String?,

    @field:Schema(description = "Type wijziging")
    val typeWijziging: TaakHistorieTypeWijziging,

    ) : AbstractHistory(
    wijzigingDatum = wijzigingDatum,
    gewijzigdDoor = gewijzigdDoor,
    oudeWaarde = oudeWaarde,
    nieuweWaarde = nieuweWaarde,
    toelichting = toelichting,
)
