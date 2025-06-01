package net.atos.esuite.extract.model.zaak

import net.atos.esuite.extract.model.basisgegevens.Subject
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class ZaakBetrokkene(
    @field:Schema(description = "Indicatie of correspondentie naar betrokkene gestuurd moet worden", required = true)
    val indCorrespondentie: Boolean,

    @field:Schema(description = "Startdatum betrokkenheid", implementation = LocalDate::class)
    val startdatum: LocalDate?,

    @field:Schema(description = "Betrokkene")
    val betrokkene: Subject,

    @field:Schema(description = "Type betrokkenheid")
    val typeBetrokkenheid: ZaakBetrokkenetype,

    @field:Schema(description = "Toelichting bij betrokkenheid")
    val toelichting: String?,
)
