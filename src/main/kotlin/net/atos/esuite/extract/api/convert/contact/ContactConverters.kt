package net.atos.esuite.extract.api.convert.contact

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.api.convert.basisgegevens.toSubject
import net.atos.esuite.extract.api.convert.shared.toKanaal
import net.atos.esuite.extract.api.convert.shared.toZonedDateTime
import net.atos.esuite.extract.api.model.bag.BAGObject
import net.atos.esuite.extract.api.model.contact.*
import net.atos.esuite.extract.db.entity.configuratiemagazijn.OrganisatieEntity
import net.atos.esuite.extract.db.entity.contactenmagazijn.*
import net.atos.esuite.extract.db.repository.basisgegevens.SubjectRepository

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
            gekoppeldeContacten = contactEntity.gekoppeldeContacten1.map { it.functioneelId }.ifEmpty { null },
            organisatie = contactEntity.organisatie?.toOrganisatie(),
        )

    fun toContactOverzicht(contactEntity: ContactEntity) =
        ContactOverzicht(
            functioneleIdentificatie = contactEntity.functioneelId,
        )
}

private fun ContactHistorieEntity.toContactHistorie() =
    ContactHistorie(
        wijzigingDatum = datumwijziging,
        gewijzigdDoor = gewijzigddoor,
        oudeWaarde = oudewaarde,
        nieuweWaarde = nieuwewaarde,
        toelichting = toelichting,
        typeWijziging = typeWijziging?.let { ContactHistorieTypeWijziging.valueOf(it.lowercase()) }
    )

private fun VoorlopigAntwoordEntity.toVoorlopigAntwoord() =
    VoorlopigAntwoord(
        antwoord = antwoord,
        antwoordDatumTijd = datumantwoord.toZonedDateTime(),
        afdeling = afdelingId,
        medewerker = medewerkerId,
    )

private fun OrganisatieEntity.toOrganisatie() =
    Organisatie(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )

private fun ContactBAGObjectEntity.toBAGObject() =
    BAGObject(
        bagObjectId = bagObjectId,
    )

private fun ContactPrioriteitEntity.toContactPrioriteit() =
    ContactPrioriteit(
        naam = naam,
        omschrijving = omschrijving,
        dagen = dagen,
        actief = actief,
    )

private fun ContactStatusEntity.toContactStatus() =
    ContactStatus(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        type = when (type) {
            ContactStatusTypeEnum.NIEUW -> net.atos.esuite.extract.api.model.contact.ContactStatusType.nieuw
            ContactStatusTypeEnum.IN_BEHANDELING -> net.atos.esuite.extract.api.model.contact.ContactStatusType.in_behandeling
            ContactStatusTypeEnum.AFGEHANDELD -> net.atos.esuite.extract.api.model.contact.ContactStatusType.afgehandeld
            null -> null
        }
    )

private fun ContactTypeEntity.toContactType() =
    Contacttype(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )
