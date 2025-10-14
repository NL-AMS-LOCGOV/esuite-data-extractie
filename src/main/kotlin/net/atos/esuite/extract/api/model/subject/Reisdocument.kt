package net.atos.esuite.extract.api.model.subject

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

@Schema(allOf = [Referentie::class])
class Reisdocument(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "GBA landcode", maxLength = 2)
    val gbaCode: String,

    @field:Schema(description = "Indicatie onttrekking aan verkeer", required = true)
    val indicatieOnttrekking: Boolean,

    @field:Schema(description = "Naam autoriteit die document heeft onttrokken", maxLength = 255)
    val autoriteitOntrekking: String?,

    @field:Schema(description = "Indicatie onttrekking aan verkeer")
    val indicatieVervallen: VervallenAanduiding?,

    @field:Schema(description = "Naam autoriteit die document heeft onttrokken", maxLength = 255)
    val autoriteitVervallen: String?,

    @field:Schema(description = "Einddatum geldigheid", implementation = LocalDate::class)
    val einddatumGeldigheid: LocalDate?,

    @field:Schema(description = "Reisdocument nummer", maxLength = 10)
    val reisdocumentnummer: String?,

    @field:Schema(description = "Uitgifte datum", implementation = LocalDate::class)
    val uitgiftedatum: LocalDate?,

    @field:Schema(description = "Naam autoriteit die document heeft onttrokken", maxLength = 128)
    val autoriteitUitgifte: String?,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
