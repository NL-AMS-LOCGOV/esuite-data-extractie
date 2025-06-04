package net.atos.esuite.extract.converter.document

import net.atos.esuite.extract.converter.toZonedDateTime
import net.atos.esuite.extract.entity.zakenmagazijn.*
import net.atos.esuite.extract.entity.zakenmagazijn.DocumentPublicatieniveau
import net.atos.esuite.extract.model.document.DocumentMetadataElementType
import net.atos.esuite.extract.model.document.DocumentOndertekening
import net.atos.esuite.extract.model.document.DocumentPublicatie
import net.atos.esuite.extract.model.document.DocumentStatus
import net.atos.esuite.extract.model.document.DocumentVorm
import net.atos.esuite.extract.model.document.Documenthistorie
import net.atos.esuite.extract.model.document.Documenttype
import net.atos.esuite.extract.model.document.Documentversie
import net.atos.esuite.extract.model.document.MetadataElement
import net.atos.esuite.extract.model.document.Taal

fun ReferentieDocumentVormEntity.toDocumentVorm() =
    DocumentVorm(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )

fun ReferentieDocumentStatusEntity.toDocumentStatus() =
    DocumentStatus(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )

fun ReferentieDocumentTypeEntity.toDocumenttype() =
    Documenttype(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        documentcategorie = documentcategorie,
        publicatieniveau = when (publicatieniveau) {
            DocumentPublicatieniveau.EXTERN -> net.atos.esuite.extract.model.document.DocumentPublicatieniveau.extern
            DocumentPublicatieniveau.INTERN -> net.atos.esuite.extract.model.document.DocumentPublicatieniveau.intern
            DocumentPublicatieniveau.VERTROUWELIJK -> net.atos.esuite.extract.model.document.DocumentPublicatieniveau.vertrouwelijk
        }
    )

fun DocumentVersieEntity.toDocumentversie(documentInhoudEntity: DocumentInhoudEntity) =
    Documentversie(
        versienummer = versienummer,
        bestandsId = documentInhoudEntity.identifier,
        documentgrootte = if (documentInhoudEntity.documentgrootte > 0) documentInhoudEntity.documentgrootte else null,
        compressed = documentInhoudEntity.compressed,
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
        omschrijving = omschrijving,
        actief = actief,
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
        actief = actief,
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

