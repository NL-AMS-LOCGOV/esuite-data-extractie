package net.atos.esuite.extract.model.contact

import net.atos.esuite.extract.model.bag.BAGObject
import net.atos.esuite.extract.model.shared.Kanaal
import net.atos.esuite.extract.model.contact.Organisatie
import net.atos.esuite.extract.model.basisgegevens.Subject
import net.atos.esuite.extract.model.contact.VoorlopigAntwoord
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.ZonedDateTime

class Contact (
    @field:Schema(description = "Functionele identificatie", maxLength = 128)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Volledige naam van aanmaker van contact", maxLength = 128)
    val aangemaaktDoor: String,

    @field:Schema(description = "Definitief gegeven antwoord")
    val antwoord: String?,

    @field:Schema(description = "Gestelde vraag")
    val vraag: String?,

    @field:Schema(description = "Telefoonnummer doorgegeven door melder/aanvrager", maxLength = 20)
    val telefoonnummer: String?,

    @field:Schema(description = "Alternatief telefoonnummer doorgegeven door melder/aanvrager", maxLength = 20)
    val telefoonnummerAlternatief: String?,

    @field:Schema(description = "Emailadres doorgegeven door melder/aanvrager", maxLength = 128)
    val emailadres: String?,

    @field:Schema(description = "Indicatie vertrouwelijk", required = true)
    val indicatieVertrouwelijk: Boolean,

    @field:Schema(description = "Indicatie of contact verwijderbaar is", required = true)
    val verwijderbaar: Boolean,

    @field:Schema(description = "Indicatie of contact in vernietiging is", required = true)
    val inVernietiging: Boolean,

    @field:Schema(description = "Aanvrager")
    val aanvrager: Subject?,

    @field:Schema(description = "BAG Objecten gerelateerd aan contact")
    val bagObjecten: List<BAGObject>?,

    @field:Schema(description = "Prioriteit van contact")
    val prioriteit: ContactPrioriteit?,

    @field:Schema(description = "Status van contact")
    val status: ContactStatus?,

    @field:Schema(description = "Type contact")
    val type: Contacttype?,

    @field:Schema(description = "Startdatum/tijd contact", implementation = ZonedDateTime::class)
    val startdatumTijd: ZonedDateTime,

    @field:Schema(description = "Streefdatum/tijd contact", implementation = ZonedDateTime::class)
    val streefdatumTijd: ZonedDateTime?,

    @field:Schema(description = "Einddatum/tijd contact", implementation = ZonedDateTime::class)
    val einddatumTijd: ZonedDateTime?,

    @field:Schema(description = "Kanaal via welke contact is binnengekomen")
    val kanaal: Kanaal?,

    @field:Schema(description = "Label KennisbankProduct uit Loket", maxLength = 255)
    val kennisbankItemLabel: String?,

    @field:Schema(description = "Groep waaraan het contact is gekoppeld", maxLength = 128)
    val groep: String?,

    @field:Schema(description = "Afdeling waaraan het contact is gekoppeld", maxLength = 128)
    val afdeling: String?,

    @field:Schema(description = "Behandelaar waaraan het contact is gekoppeld", maxLength = 64)
    val behandelaar: String?,

    @field:Schema(description = "Contact historie")
    val historie: List<ContactHistorie>?,

    @field:Schema(description = "Voorlopige antwoorden")
    val voorlopigeAntwoorden: List<VoorlopigAntwoord>?,

    @field:Schema(description = "Functionele identificatie van gekoppelde contacten")
    val gekoppeldeContacten: List<String>?,

    @field:Schema(description = "Organisatie behorende bij contact")
    val organisatie: Organisatie?,
)
