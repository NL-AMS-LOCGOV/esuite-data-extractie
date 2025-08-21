package net.atos.esuite.extract.api.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class ReferentietabelRecord(

    @field:Schema(description = "Naam van record", maxLength = 128)
    val naam: String,

    @field:Schema(description = "Omschrijving van record", maxLength = 128)
    val omschrijving: String,

    @field:Schema(description = "Datum vanaf wanneer record geldig is ", implementation = LocalDate::class)
    val ingangsdatumGeldigheid: LocalDate,

    @field:Schema(description = "Datum waarna record niet meer geldig is", implementation = LocalDate::class)
    val einddatumGeldigheid: LocalDate?,

    @field:Schema(description = "Categorie van record", maxLength = 64)
    val categorie: String?,

    @field:Schema(description = "Attributen in record")
    val attributen: List<ReferentietabelRecordAttribuut>,
    )
