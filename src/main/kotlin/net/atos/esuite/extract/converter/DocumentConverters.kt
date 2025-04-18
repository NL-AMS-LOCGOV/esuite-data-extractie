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
    Documentversie()

fun DocumentMetadataEntity.toDocumentMetadata() =
    DocumentMetadata()

fun DocumenthistorieEntity.toDocumentHistorie() =
    Documenthistorie()

fun DocumentPublicatieEntity.toDocumentPublicatie() =
    DocumentPublicatie()

fun ReferentieTaalEntity.toTaal() =
    Taal(
        naam = naam,
        omschrijving = omschrijving,
        functioneelId = functioneelId,
    )

