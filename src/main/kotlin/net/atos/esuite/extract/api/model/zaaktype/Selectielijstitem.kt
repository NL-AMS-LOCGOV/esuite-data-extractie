package net.atos.esuite.extract.api.model.zaaktype

import net.atos.esuite.extract.api.model.shared.Referentie
import net.atos.esuite.extract.api.model.zaak.BewaartermijnWaardering
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Selectielijstitem(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Versie (jaar) van selectielijst item", required = false)
    val jaar: Int?,

    @field:Schema(description = "Naam van domein", maxLength = 255, required = false)
    val domein: String?,

    @field:Schema(description = "Naam van subdomein", maxLength = 255, required = false)
    val subdomein: String?,

    @field:Schema(description = "Waardering van de bewaartermijn", required = false)
    val bewaartermijnWaardering: BewaartermijnWaardering?,

    @field:Schema(description = "Bewaartermijn. Voor eenheid zie bewaartermijnEenheid", required = false)
    val bewaartermijn: Int?,

    @field:Schema(description = "Bewaartermijn eenheid", required = false)
    val bewaartermijnEenheid: BewaartermijnEenheid?,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
