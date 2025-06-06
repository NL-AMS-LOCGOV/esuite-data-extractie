package net.atos.esuite.extract.model.dsr.domein

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

class DomeinObject(
    @field:Schema(description = "Unieke identificatie van het domein object", required = true)
    val identifier: Long,

    @field:Schema(description = "Naam van type domein object", maxLength = 128)
    val naam: String,

    @field:Schema(description = "Omschrijving van type domein object")
    val omschrijving: String?,

    @field:Schema(description = "Gebruikersnaam van medewerker die domein object heeft aangemaakt", maxLength = 64)
    val aangemaaktDoor: String,

    @field:Schema(description = "Datum waarop domein object is aangemaakt", implementation = LocalDate::class)
    val aangemaaktOp: LocalDate,

    @field:Schema(
        description = "Gebruikersnaam van medewerker die domein object als laatste heeft gewijzigd",
        maxLength = 64
    )
    val laatstGewijzigdDoor: String?,

    @field:Schema(
        description = "Datum waarop domein object de laatste keer is gewijzigd",
        implementation = LocalDate::class
    )
    val laatstGewijzigdOp: LocalDate?,

    @field:Schema(description = "Attributen gerelateerd aan domein object")
    val attributen: List<DomeinObjectAttribuut>,

    @field:Schema(description = "Zaken, contacten, personen, bedrijven of BAG objecten waaraan domein object gekoppeld is")
    val koppelingen: List<DomeinObjectKoppeling>?,

    @field:Schema(description = "Historie van domein object")
    val historie: List<DomeinObjectHistorie>?,
    )
