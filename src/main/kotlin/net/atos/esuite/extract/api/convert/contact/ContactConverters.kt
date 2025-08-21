package net.atos.esuite.extract.api.convert.contact

import net.atos.esuite.extract.api.convert.shared.toZonedDateTime
import net.atos.esuite.extract.api.model.bag.BAGObject
import net.atos.esuite.extract.api.model.contact.*
import net.atos.esuite.extract.db.entity.configuratiemagazijn.ReferentieOrganisatieEntity
import net.atos.esuite.extract.db.entity.contactenmagazijn.*
import net.atos.esuite.extract.db.entity.contactenmagazijn.ContactStatusType

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
            ContactStatusType.NIEUW -> net.atos.esuite.extract.api.model.contact.ContactStatusType.nieuw
            ContactStatusType.IN_BEHANDELING -> net.atos.esuite.extract.api.model.contact.ContactStatusType.in_behandeling
            ContactStatusType.AFGEHANDELD -> net.atos.esuite.extract.api.model.contact.ContactStatusType.afgehandeld
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
