package net.atos.esuite.extract.api.model.dsr.tabel

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Referentietabel(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Is referentie tabel een master/detail referentie tabel", required = true)
    val masterDetail: Boolean,

    @field:Schema(description = "Aantal records in tabel")
    val aantalRecords: Long,
) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
