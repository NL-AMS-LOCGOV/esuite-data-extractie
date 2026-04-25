package net.atos.esuite.extract.api.model.contact

import net.atos.esuite.extract.api.model.bag.BAGObject
import net.atos.esuite.extract.api.model.dsr.domein.DomeinObject
import net.atos.esuite.extract.api.model.shared.Kanaal
import net.atos.esuite.extract.api.model.subject.Subject
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.ZonedDateTime

class Contact (
    @field:Schema(description = "Functionele identificatie", maxLength = 128)
    val functioneleIdentificatie: String,

    @field:Schema(description = "Volledige naam van aanmaker van contact", maxLength = 128)
    val aangemaaktDoor: String,

    @field:Schema(description = "Definitief gegeven antwoord", required = false)
    val antwoord: String?,

    @field:Schema(description = "Gestelde vraag", required = false)
    val vraag: String?,

    @field:Schema(description = "Telefoonnummer doorgegeven door melder/aanvrager", maxLength = 20, required = false)
    val telefoonnummer: String?,

    @field:Schema(description = "Alternatief telefoonnummer doorgegeven door melder/aanvrager", maxLength = 20, required = false)
    val telefoonnummerAlternatief: String?,

    @field:Schema(description = "Emailadres doorgegeven door melder/aanvrager", maxLength = 128, required = false)
    val emailadres: String?,

    @field:Schema(description = "Indicatie vertrouwelijk")
    val indicatieVertrouwelijk: Boolean,

    @field:Schema(description = "Indicatie of contact verwijderbaar is")
    val verwijderbaar: Boolean,

    @field:Schema(description = "Indicatie of contact in vernietiging is")
    val inVernietiging: Boolean,

    @field:Schema(description = "Aanvrager", required = false)
    val aanvrager: Subject?,

    @field:Schema(description = "BAG Objecten gerelateerd aan contact", required = false)
    val bagObjecten: List<BAGObject>?,

    @field:Schema(description = "Prioriteit van contact", required = false)
    val prioriteit: ContactPrioriteit?,

    @field:Schema(description = "Status van contact", required = false)
    val status: ContactStatus?,

    @field:Schema(description = "Type contact", required = false)
    val type: Contacttype?,

    @field:Schema(description = "Startdatum/tijd contact", implementation = ZonedDateTime::class)
    val startdatumTijd: ZonedDateTime,

    @field:Schema(description = "Streefdatum/tijd contact", implementation = ZonedDateTime::class, required = false)
    val streefdatumTijd: ZonedDateTime?,

    @field:Schema(description = "Einddatum/tijd contact", implementation = ZonedDateTime::class, required = false)
    val einddatumTijd: ZonedDateTime?,

    @field:Schema(description = "Kanaal via welke contact is binnengekomen", required = false)
    val kanaal: Kanaal?,

    @field:Schema(description = "Label KennisbankProduct uit Loket", maxLength = 255, required = false)
    val kennisbankItemLabel: String?,

    @field:Schema(description = "Groep waaraan het contact is gekoppeld", maxLength = 128, required = false)
    val groep: String?,

    @field:Schema(description = "Afdeling waaraan het contact is gekoppeld", maxLength = 128, required = false)
    val afdeling: String?,

    @field:Schema(description = "Behandelaar waaraan het contact is gekoppeld", maxLength = 64, required = false)
    val behandelaar: String?,

    @field:Schema(description = "Contact historie", required = false)
    val historie: List<ContactHistorie>?,

    @field:Schema(description = "Voorlopige antwoorden", required = false)
    val voorlopigeAntwoorden: List<VoorlopigAntwoord>?,

    @field:Schema(description = "Functionele identificatie van gekoppelde contacten", required = false)
    val gekoppeldeContacten: List<String>?,

    @field:Schema(description = "Organisatie behorende bij contact", required = false)
    val organisatie: Organisatie?,

    @field:Schema(description = "Domein Objecten gerelateerd aan contact", required = false)
    val domeinObjecten: List<DomeinObject>?,
)
