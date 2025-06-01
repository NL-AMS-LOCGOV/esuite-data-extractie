package net.atos.esuite.extract.model.identity

import net.atos.esuite.extract.model.identity.Functie
import net.atos.esuite.extract.model.identity.Rol
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate
import java.time.ZonedDateTime

class Medewerker(

    @field:Schema(description = "Gebruikersnaam van medewerker", maxLength = 128, uniqueItems = true)
    val gebruikersnaam: String,

    @field:Schema(description = "Volledige naam van medewerker", maxLength = 128)
    val volledigeNaam: String,

    @field:Schema(description = "Telefoonnummer van medewerker", maxLength = 20)
    val telefoonnummer: String?,

    @field:Schema(description = "E-mailadres van medewerker", maxLength = 64)
    val emailadres: String?,

    @field:Schema(description = "Is medewerker actief", required = true)
    val actief: Boolean,

    @field:Schema(description = "Datum indiensttreding", implementation = LocalDate::class)
    val indiensttredingDatum: LocalDate?,

    @field:Schema(description = "Datum uitdiensttreding", implementation = LocalDate::class)
    val uitdiensttredingDatum: LocalDate?,

    @field:Schema(description = "Is medewerker locked", required = true)
    val locked: Boolean,

    @field:Schema(description = "Externe naam van medewerker", maxLength = 128)
    val externeNaam: String?,

    @field:Schema(description = "Functie van medewerker")
    val functie: Functie?,

    @field:Schema(description = "Geslacht medewerker")
    val geslacht: GeslachtMedewerker,

    @field:Schema(description = "Laatste logon datum/tijd van medewerker", implementation = ZonedDateTime::class)
    val laatsteLoginDatumTijd: ZonedDateTime?,

    @field:Schema(description = "Opmerkingen")
    val opmerkingen: String?,

    @field:Schema(description = "Naam primaire afdeling")
    val primaireAfdeling: String?,

    @field:Schema(description = "Namen van afdelingen waarin medewerker zich bevindt")
    val afdelingen: Set<String>,

    @field:Schema(description = "Namen van groepen waarin medewerker zich bevindt")
    val groepen: Set<String>,

    @field:Schema(description = "Namen van afdelingen waar medewerker hoofd van is")
    val afdelingshoofdVan: Set<String>,

    @field:Schema(description = "Namen van groepen waar medewerker hoofd van is")
    val groepshoofdVan: Set<String>,

    @field:Schema(description = "Rollen van medewerker")
    val rollen: Set<Rol>,

    @field:Schema(description = "Rechten van medewerker")
    val rechten: Set<Recht>,
)
