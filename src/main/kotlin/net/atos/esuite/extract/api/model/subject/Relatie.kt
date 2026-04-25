package net.atos.esuite.extract.api.model.subject

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class Relatie(

    @field:Schema(description = "Aanduiding relatie")
    val type: RelatieType,

    @field:Schema(description = "Soort verbintenis", required = false)
    val soortVerbintenis: SoortVerbintenis?,

    @field:Schema(description = "Datum sluiting van verbintenis", implementation = LocalDate::class, required = false)
    val datumSluitingVerbintenis: LocalDate?,

    @field:Schema(description = "Plaats van sluiting van verbintenis", maxLength = 128, required = false)
    val plaatsSluitingVerbintenis: String?,

    @field:Schema(description = "Land van sluiting van verbintenis", required = false)
    val landSluitingVerbintenis: Land?,

    @field:Schema(description = "Datum ontbinding verbintenis", implementation = LocalDate::class, required = false)
    val datumOntbindingVerbintenis: LocalDate?,

    @field:Schema(description = "Reden ontbinding verbintenis", required = false)
    val redenOntbindingVerbintenis: RedenOntbindingVerbintenis?,

    @field:Schema(description = "Plaats van de ontbinding van verbintenis", maxLength = 128, required = false)
    val plaatsOntbindingVerbintenis: String?,

    @field:Schema(description = "Land van ontbinding van verbintenis", required = false)
    val landOntbindingVerbintenis: Land?,

    @field:Schema(description = "Interne identifier van gerelateerd persoon")
    val identifierPersoon: Long,
)
