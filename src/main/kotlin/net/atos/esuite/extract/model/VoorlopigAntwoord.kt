package net.atos.esuite.extract.model

import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import net.atos.esuite.extract.entity.contactenmagazijn.ContactEntity
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.Instant
import java.time.ZonedDateTime

class VoorlopigAntwoord(

    @field:Schema(description = "Voorlopig antwoord")
    val antwoord: String,

    @field:Schema(description = "Datum/tijd voorlopige antwoord", implementation = ZonedDateTime::class)
    val antwoordDatumTijd: ZonedDateTime,

    @field:Schema(description = "Afdeling", maxLength = 128)
    val afdeling: String?,

    @field:Schema(description = "Medewerker", maxLength = 64)
    val medewerker: String?,
)
