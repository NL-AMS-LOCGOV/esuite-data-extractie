package net.atos.esuite.extract.converter

import net.atos.esuite.extract.entity.zakenmagazijn.*
import net.atos.esuite.extract.entity.zakenmagazijn.DocumentPublicatieniveau
import net.atos.esuite.extract.model.*

fun ReferentieDocumentVormEntity.toDocumentVorm() =
    DocumentVorm(
        naam = naam,
        omschrijving = omschrijving,
    )

fun ReferentieDocumentStatusEntity.toDocumentStatus() =
    DocumentStatus(
        naam = naam,
        omschrijving = omschrijving,
    )

fun ReferentieDocumentTypeEntity.toDocumenttype() =
    Documenttype(
        naam = naam,
        omschrijving = omschrijving,
        documentcategorie = documentcategorie,
        publicatieniveau = when (publicatieniveau) {
            DocumentPublicatieniveau.EXTERN -> net.atos.esuite.extract.model.DocumentPublicatieniveau.extern
            DocumentPublicatieniveau.INTERN -> net.atos.esuite.extract.model.DocumentPublicatieniveau.intern
            DocumentPublicatieniveau.VERTROUWELIJK -> net.atos.esuite.extract.model.DocumentPublicatieniveau.vertrouwelijk
        }
    )

fun DocumentVersieEntity.toDocumentversie() =
    Documentversie(
        versienummer = versienummer,
        bestandsId = inhoud.identifier.toString(),
        documentgrootte = if (inhoud.documentgrootte > 0) inhoud.documentgrootte else null,
        compressed = inhoud.compressed,
        creatiedatum = creatiedatum,
        auteur = auteur,
        afzender = afzender,
        bestandsnaam = bestandsnaam,
        mimetype = mimetype,
        ondertekeningen = ondertekeningen.map { it.toDocumentOndertekening() }.ifEmpty { null },
    )

fun ReferentieMetadataelementEntity.toMetadataelement() =
    MetadataElement(
        naam = naam,
        omschrijving,
        label = label,
        type = DocumentMetadataElementType.valueOf(type.lowercase()),
        indicatieVerplicht = indicatieVerplicht,
        indicatieVoorAlleDocumenttypes = indicatieVoorAlleDocumenttypes,
    )

fun DocumenthistorieEntity.toDocumentHistorie() =
    Documenthistorie(
        wijzigingDatum = datumwijziging,
        gewijzigdDoor = gewijzigddoor,
        oudeWaarde = oudewaarde,
        nieuweWaarde = nieuwewaarde,
        toelichting = toelichting,
        typeWijziging = typeWijziging,
    )

fun DocumentPublicatieEntity.toDocumentPublicatie() =
    DocumentPublicatie(
        publicatiedatum = publicatiedatum,
    )

fun ReferentieTaalEntity.toTaal() =
    Taal(
        naam = naam,
        omschrijving = omschrijving,
        functioneelId = functioneelId,
    )

fun DocumentOndertekeningEntity.toDocumentOndertekening() =
    DocumentOndertekening(
        documentTitel = documentTitel,
        ondertekenaar = ondertekenaar,
        ondertekenDatum = ondertekenDatum.toZonedDateTime(),
        creatieDatum = creatieDatum,
        opmerking = opmerking,
        gemandateerd = gemandateerd,
    )

