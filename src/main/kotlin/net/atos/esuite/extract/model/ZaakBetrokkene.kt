package net.atos.esuite.extract.model

import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import net.atos.esuite.extract.entity.basisgegevens.SubjectEntity
import net.atos.esuite.extract.entity.zakenmagazijn.ZaakEntity
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
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
