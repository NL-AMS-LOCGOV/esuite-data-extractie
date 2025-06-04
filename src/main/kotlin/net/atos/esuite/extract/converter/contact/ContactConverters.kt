package net.atos.esuite.extract.converter.contact

import net.atos.esuite.extract.converter.toZonedDateTime
import net.atos.esuite.extract.entity.configuratiemagazijn.ReferentieOrganisatieEntity
import net.atos.esuite.extract.entity.contactenmagazijn.ContactBAGObjectEntity
import net.atos.esuite.extract.entity.contactenmagazijn.ContactHistorieEntity
import net.atos.esuite.extract.entity.contactenmagazijn.ContactStatusType
import net.atos.esuite.extract.entity.contactenmagazijn.ReferentieContactPrioriteitEntity
import net.atos.esuite.extract.entity.contactenmagazijn.ReferentieContactStatusEntity
import net.atos.esuite.extract.entity.contactenmagazijn.ReferentieContactTypeEntity
import net.atos.esuite.extract.entity.contactenmagazijn.VoorlopigAntwoordEntity
import net.atos.esuite.extract.model.bag.BAGObject
import net.atos.esuite.extract.model.contact.ContactHistorie
import net.atos.esuite.extract.model.contact.ContactHistorieTypeWijziging
import net.atos.esuite.extract.model.contact.ContactPrioriteit
import net.atos.esuite.extract.model.contact.ContactStatus
import net.atos.esuite.extract.model.contact.Contacttype
import net.atos.esuite.extract.model.contact.Organisatie
import net.atos.esuite.extract.model.contact.VoorlopigAntwoord

fun ContactBAGObjectEntity.toBAGObject() = BAGObject(
    bagObjectId = bagObjectId,
)

fun ReferentieContactPrioriteitEntity.toContactPrioriteit() =
    ContactPrioriteit(
        naam = naam,
        omschrijving = omschrijving,
        dagen = dagen,
        actief = actief,
    )

fun ReferentieContactStatusEntity.toContactStatus() =
    ContactStatus(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        type = when (type) {
            ContactStatusType.NIEUW -> net.atos.esuite.extract.model.contact.ContactStatusType.nieuw
            ContactStatusType.IN_BEHANDELING -> net.atos.esuite.extract.model.contact.ContactStatusType.in_behandeling
            ContactStatusType.AFGEHANDELD -> net.atos.esuite.extract.model.contact.ContactStatusType.afgehandeld
            null -> null
        }
    )

fun ReferentieContactTypeEntity.toContactType() =
    Contacttype(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )

fun ContactHistorieEntity.toContactHistorie() =
    ContactHistorie(
        wijzigingDatum = datumwijziging,
        gewijzigdDoor = gewijzigddoor,
        oudeWaarde = oudewaarde,
        nieuweWaarde = nieuwewaarde,
        toelichting = toelichting,
        typeWijziging = typeWijziging?.let { ContactHistorieTypeWijziging.valueOf(it.lowercase()) }
    )

fun VoorlopigAntwoordEntity.toVoorlopigAntwoord() =
    VoorlopigAntwoord(
        antwoord = antwoord,
        antwoordDatumTijd = datumantwoord.toZonedDateTime(),
        afdeling = afdelingId,
        medewerker = medewerkerId,
    )

fun ReferentieOrganisatieEntity.toOrganisatie() =
    Organisatie(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )
