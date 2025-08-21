package net.atos.esuite.extract.api.model.basisgegevens

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class Relatie(

    @field:Schema(description = "Aanduiding relatie")
    val type: RelatieType,

    @field:Schema(description = "Soort verbintenis")
    val soortVerbintenis: SoortVerbintenis?,

    @field:Schema(description = "Datum sluiting van verbintenis", implementation = LocalDate::class)
    val datumSluitingVerbintenis: LocalDate?,

    @field:Schema(description = "Plaats van sluiting van verbintenis", maxLength = 128)
    val plaatsSluitingVerbintenis: String?,

    @field:Schema(description = "Land van sluiting van verbintenis")
    val landSluitingVerbintenis: Land?,

    @field:Schema(description = "Datum ontbinding verbintenis", implementation = LocalDate::class)
    val datumOntbindingVerbintenis: LocalDate?,

    @field:Schema(description = "Reden ontbinding verbintenis")
    val redenOntbindingVerbintenis: RedenOntbindingVerbintenis?,

    @field:Schema(description = "Plaats van de ontbinding van verbintenis", maxLength = 128)
    val plaatsOntbindingVerbintenis: String?,

    @field:Schema(description = "Land van ontbinding van verbintenis")
    val landOntbindingVerbintenis: Land?,

    @field:Schema(description = "Interne identifier van gerelateerd persoon")
    val identifierPersoon: Long,
)
