package net.atos.esuite.extract.model

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class ContactHistorie(
    wijzigingDatum: LocalDate?,
    gewijzigdDoor: String?,
    oudeWaarde: String?,
    nieuweWaarde: String?,
    toelichting: String?,

    @field:Schema(description = "Type wijziging")
    val typeWijziging: ContactHistorieTypeWijziging?,

    ) : AbstractHistory(
    wijzigingDatum = wijzigingDatum,
    gewijzigdDoor = gewijzigdDoor,
    oudeWaarde = oudeWaarde,
    nieuweWaarde = nieuweWaarde,
    toelichting = toelichting,
)
