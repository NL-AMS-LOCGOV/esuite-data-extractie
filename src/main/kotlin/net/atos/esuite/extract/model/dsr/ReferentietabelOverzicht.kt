package net.atos.esuite.extract.model.dsr

import net.atos.esuite.extract.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class ReferentietabelOverzicht(
    naam: String,
    omschrijving: String?,

    @field:Schema(description = "Aantal records in tabel")
    val aantalRecords: Long,
) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
)
