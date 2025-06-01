package net.atos.esuite.extract.model.basisgegevens

import org.eclipse.microprofile.openapi.annotations.media.DiscriminatorMapping
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(
    oneOf = [Persoon::class, Bedrijf::class],
    discriminatorProperty = "subjecttype",
    discriminatorMapping = [
        DiscriminatorMapping("persoon", schema = Persoon::class),
        DiscriminatorMapping("bedrijf", schema = Bedrijf::class)
    ]
)
abstract class Subject(

    @field:Schema(description = "Type subject")
    val subjecttype: Subjecttype,

    @field:Schema(description = "Telefoonnummer", maxLength = 20)
    val telefoonnummer: String?,

    @field:Schema(description = "Alternatief telefoonnummer", maxLength = 20)
    val telefoonnummerAlternatief: String?,

    @field:Schema(description = "Bankrekeningnummer", maxLength = 64)
    val rekeningnummer: String?,

    @field:Schema(description = "Emailadres", maxLength = 255)
    val emailadres: String?,

    @field:Schema(description = "Notities")
    val notities: List<SubjectNotitie>?
)

