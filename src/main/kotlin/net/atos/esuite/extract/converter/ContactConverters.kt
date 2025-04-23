package net.atos.esuite.extract.converter

import net.atos.esuite.extract.entity.configuratiemagazijn.ReferentieOrganisatieEntity
import net.atos.esuite.extract.entity.contactenmagazijn.ContactBAGObjectEntity
import net.atos.esuite.extract.entity.contactenmagazijn.ContactHistorieEntity
import net.atos.esuite.extract.entity.contactenmagazijn.ContactStatusType
import net.atos.esuite.extract.entity.contactenmagazijn.ReferentieContactPrioriteitEntity
import net.atos.esuite.extract.entity.contactenmagazijn.ReferentieContactStatusEntity
import net.atos.esuite.extract.entity.contactenmagazijn.ReferentieContactTypeEntity
import net.atos.esuite.extract.entity.contactenmagazijn.VoorlopigAntwoordEntity
import net.atos.esuite.extract.entity.zakenmagazijn.ZaakBAGObjectEntity
import net.atos.esuite.extract.model.BAGObject
import net.atos.esuite.extract.model.ContactHistorie
import net.atos.esuite.extract.model.ContactHistorieTypeWijziging
import net.atos.esuite.extract.model.ContactPrioriteit
import net.atos.esuite.extract.model.ContactStatus
import net.atos.esuite.extract.model.Contacttype
import net.atos.esuite.extract.model.Organisatie
import net.atos.esuite.extract.model.VoorlopigAntwoord

fun ContactBAGObjectEntity.toBAGObject() = BAGObject(
    bagObjectId = bagObjectId,
)

fun ReferentieContactPrioriteitEntity.toContactPrioriteit() =
    ContactPrioriteit(
        naam = naam,
        omschrijving = omschrijving,
        dagen = dagen,
    )

fun ReferentieContactStatusEntity.toContactStatus() =
    ContactStatus(
        naam = naam,
        omschrijving = omschrijving,
        type = when (type) {
            ContactStatusType.NIEUW -> net.atos.esuite.extract.model.ContactStatusType.nieuw
            ContactStatusType.IN_BEHANDELING -> net.atos.esuite.extract.model.ContactStatusType.in_behandeling
            ContactStatusType.AFGEHANDELD -> net.atos.esuite.extract.model.ContactStatusType.afgehandeld
            null -> null
        }
    )

fun ReferentieContactTypeEntity.toContactType() =
    Contacttype(
        naam = naam,
        omschrijving = omschrijving,
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
    )
