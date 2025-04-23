package net.atos.esuite.extract.converter

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.contactenmagazijn.ContactEntity
import net.atos.esuite.extract.model.Contact
import net.atos.esuite.extract.model.ContactOverzicht
import net.atos.esuite.extract.repository.SubjectRepository

@ApplicationScoped
class ContactConverter(
    private val subjectRepository: SubjectRepository,
) {
    fun toContact(contactEntity: ContactEntity) =
        Contact(
            functioneleIdentificatie = contactEntity.functioneelId,
            aangemaaktDoor = contactEntity.aangemaaktDoorId,
            antwoord = contactEntity.antwoord,
            vraag = contactEntity.vraag,
            telefoonnummer = contactEntity.telefoon,
            telefoonnummerAlternatief = contactEntity.telefoonAlternatief,
            emailadres = contactEntity.emailadres,
            indicatieVertrouwelijk = contactEntity.indicatieVertrouwelijk,
            verwijderbaar = contactEntity.verwijderbaar,
            inVernietiging = contactEntity.inVernietiging,
            aanvrager = contactEntity.aanvragerSubjectId?.let {
                subjectRepository.findById(it)
                    ?.toSubject()
                    ?: error("Aanvrager with id ${it} not found")
            },
            bagObjecten = contactEntity.gekoppeldeBAGObjecten.map { it.toBAGObject() }.ifEmpty { null },
            prioriteit = contactEntity.contactPrioriteit?.toContactPrioriteit(),
            status = contactEntity.contactStatus?.toContactStatus(),
            type = contactEntity.contactType?.toContactType(),
            startdatumTijd = contactEntity.startdatumtijd.toZonedDateTime(),
            streefdatumTijd = contactEntity.streefdatumtijd?.toZonedDateTime(),
            einddatumTijd = contactEntity.einddatumtijd?.toZonedDateTime(),
            kanaal = contactEntity.kanaal?.toKanaal(),
            kennisbankItemLabel = contactEntity.kennisbankItemLabel,
            groep = contactEntity.groepId,
            afdeling = contactEntity.afdelingId,
            behandelaar = contactEntity.behandelaarId,
            historie = contactEntity.contactHistorie.map { it.toContactHistorie() }.ifEmpty { null },
            voorlopigeAntwoorden = contactEntity.voorlopigeAntwoorden.map { it.toVoorlopigAntwoord() }.ifEmpty { null },
            gekoppeldeContacten = contactEntity.gekoppeldeContacten1.map { it.functioneelId }
                .ifEmpty { null }, // ToDo klopt dit zo?
            organisatie = contactEntity.organisatie?.toOrganisatie(),
        )

    fun toContactOverzicht(contactEntity: ContactEntity) =
        ContactOverzicht(
            functioneleIdentificatie = contactEntity.functioneelId,
        )
}
