package net.atos.esuite.extract.model.contact

import net.atos.esuite.extract.model.shared.History
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

@Schema(allOf = [History::class])
class ContactHistorie(
    wijzigingDatum: LocalDate?,
    gewijzigdDoor: String?,
    oudeWaarde: String?,
    nieuweWaarde: String?,
    toelichting: String?,

    @field:Schema(description = "Type wijziging")
    val typeWijziging: ContactHistorieTypeWijziging?,

    ) : History(
    wijzigingDatum = wijzigingDatum,
    gewijzigdDoor = gewijzigdDoor,
    oudeWaarde = oudeWaarde,
    nieuweWaarde = nieuweWaarde,
    toelichting = toelichting,
)
