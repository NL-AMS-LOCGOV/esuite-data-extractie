package net.atos.esuite.extract.api.model.besluit

import net.atos.esuite.extract.api.model.document.Documenttype
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class Besluit (
    @field:Schema(description = "Functionele identificatie van het besluit", maxLength = 128)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Besluittype")
    val besluittype: Besluittype,

    @field:Schema(description = "Functionele identificatie van aan besluit gerelateerd document", maxLength = 36, required = false)
    val functioneleIdentificatieDocument: String?,

    @field:Schema(description = "Aan besluit gerelateerd documenttype", required = false)
    val documenttype: Documenttype?,

    @field:Schema(description = "Datum waarop besluit is aangemaakt", implementation = LocalDate::class)
    val besluitDatum: LocalDate,

    @field:Schema(description = "Datum waarop het besluit vervalt", implementation = LocalDate::class, required = false)
    val vervaldatum: LocalDate?,

    @field:Schema(description = "Datum vanaf wanneer besluit geldig is", implementation = LocalDate::class, required = false)
    val ingangsdatum: LocalDate?,

    @field:Schema(description = "Uiterlijke reactie datum", implementation = LocalDate::class, required = false)
    val reactiedatum: LocalDate?,

    @field:Schema(description = "Publicatie  datum van het beluit", implementation = LocalDate::class, required = false)
    val publicatiedatum: LocalDate?,

    @field:Schema(description = "Geeft aan of vervaldatum moet worden berekend op het moment dat zaak beeindigd wordt")
    val berekenVervaldatum: Boolean,

    @field:Schema(description = "Toelichting op besluit", required = false)
    val toelichting: String?,

    @field:Schema(description = "Procestermijn in maanden voor berekening van vervaldatum", required = false)
    val procestermijnInMaanden: Int?,
    )
