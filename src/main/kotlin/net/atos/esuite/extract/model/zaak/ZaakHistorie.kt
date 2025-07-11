package net.atos.esuite.extract.model.zaak

import net.atos.esuite.extract.model.shared.History
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

@Schema(allOf = [History::class])
class ZaakHistorie(
    wijzigingDatum: LocalDate?,
    gewijzigdDoor: String?,
    oudeWaarde: String?,
    nieuweWaarde: String?,
    toelichting: String?,

    @field:Schema(description = "Type wijziging")
    val typeWijziging: ZaakHistorieTypeWijziging,

    @field:Schema(description = "Externe nieuwe waarde")
    val nieuweWaardeExtern: String?,
    
) : History(
    wijzigingDatum = wijzigingDatum,
    gewijzigdDoor = gewijzigdDoor,
    oudeWaarde = oudeWaarde,
    nieuweWaarde = nieuweWaarde,
    toelichting = toelichting,
)
