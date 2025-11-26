package net.atos.esuite.extract.api.converter

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.api.model.document.*
import net.atos.esuite.extract.db.zakenmagazijn.entity.*
import net.atos.esuite.extract.db.zakenmagazijn.repository.*

@ApplicationScoped
class DocumentConverter(
    private val documentTypeRepository: DocumentTypeRepository,
    private val documentStatusRepository: DocumentStatusRepository,
    private val documentVormRepository: DocumentVormRepository,
    private val taalRepository: TaalRepository,
    private val metadataelementRepository: MetadataelementRepository,
    private val documentInhoudRepository: DocumentInhoudRepository,
) {
    private val BESTANDS_ID_PREFIX = "dms:"

    fun toDocument(documentEntity: DocumentEntity) =
        Document(
            functioneleIdentificatie = documentEntity.idFunctioneel,
            documentVorm = documentEntity.documentvormId?.let { toDocumentVorm(it) },
            documentStatus = toDocumentStatus(documentEntity.documentstatusId),
            documenttype = toDocumenttype(documentEntity.documenttypeId),
            titel = documentEntity.titel,
            kenmerk = documentEntity.kenmerk,
            creatieDatumTijd = documentEntity.creatiedatum.toZonedDateTime(),
            wijzigDatumTijd = documentEntity.wijzigdatum?.toZonedDateTime(),
            publicatieniveau = when (documentEntity.publicatieniveau) {
                DocumentPublicatieniveauEnum.EXTERN -> DocumentPublicatieniveau.extern
                DocumentPublicatieniveauEnum.INTERN -> DocumentPublicatieniveau.intern
                DocumentPublicatieniveauEnum.VERTROUWELIJK -> DocumentPublicatieniveau.vertrouwelijk
            },
            documentVersturen = when (documentEntity.documentVersturen) {
                DocumentVersturenEnum.IS_VERSTUURD -> DocumentVersturen.is_verstuurd
                DocumentVersturenEnum.MOET_NIET_VERSTUURD_WORDEN -> DocumentVersturen.moet_niet_verstuurd_worden
                null -> null
            },
            documentVersturenDatum = documentEntity.documentVersturenDatum,
            aanvraagDocument = documentEntity.indAanvraag,
            ontvangstDatum = if (documentEntity.documentrichting == DocumentRichtingEnum.INKOMEND) documentEntity.ontvangstverzendcreatiedatum else null,
            verzendDatum = if (documentEntity.documentrichting == DocumentRichtingEnum.UITGAAND) documentEntity.ontvangstverzendcreatiedatum else null,
            documentrichting = when (documentEntity.documentrichting) {
                DocumentRichtingEnum.INKOMEND -> DocumentRichting.inkomend
                DocumentRichtingEnum.UITGAAND -> DocumentRichting.uitgaand
                DocumentRichtingEnum.INTERN -> DocumentRichting.intern
            },
            locatie = documentEntity.locatie,
            beschrijving = documentEntity.beschrijving,
            lockEigenaarId = documentEntity.lockEigenaarId,
            lockDatumTijd = documentEntity.lockDatumTijd?.toZonedDateTime(),
            documentversies = documentEntity.documentversies.map { it.toDocumentversie(toDocumentInhoudEntity(it.bestandsId)) },
            documentMetadata = documentEntity.documentMetadata.map { toDocumentMetadata(it) }.ifEmpty { null },
            taak = documentEntity.taak?.toTaak(),
            historie = documentEntity.historie.map { it.toDocumentHistorie() },
            publicaties = documentEntity.publicaties.map { it.toDocumentPublicatie() }.ifEmpty { null },
            pdfaDocumentversie = documentEntity.pdfaDocumentVersieEntity?.let {
                it.toDocumentversie(toDocumentInhoudEntity(it.bestandsId))
            },
            taal = documentEntity.taalId?.let { toTaal(it) },
            geautoriseerdeMedewerkers = documentEntity.geautoriseerdeMedewerkers.ifEmpty { null },
            geautoriseerdVoorMedewerkers = documentEntity.autorisatie,
            converterenNaarPdfa = documentEntity.converterenNaarPdfa,
        )

    fun toDocumenttype(documenttypeId: String) =
        documentTypeRepository.findById(documenttypeId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toDocumenttype()
            ?: error("Document type id not found: $documenttypeId")

    private fun toDocumentVorm(documentVormId: String) =
        documentVormRepository.findById(documentVormId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toDocumentVorm()
            ?: error("Document vorm id not found: $documentVormId")

    private fun toDocumentStatus(documentStatusID: String) =
        documentStatusRepository.findById(documentStatusID.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toDocumentStatus()
            ?: error("Document status id not found: $documentStatusID")

    private fun toTaal(taalId: String) =
        taalRepository.findById(taalId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toTaal()
            ?: error("Taal with id $taalId not found")

    private fun toMetadataElement(metadataelementId: String) =
        metadataelementRepository.findById(metadataelementId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toMetadataelement()
            ?: error("Metadata element id not found: $metadataelementId")

    private fun toDocumentMetadata(documentMetadataEntity: DocumentMetadataEntity) =
        DocumentMetadata(
            metadataElement = documentMetadataEntity.metadataelementId?.let { toMetadataElement(it) },
            waarde = documentMetadataEntity.waardeMetadata,
        )

    private fun toDocumentInhoudEntity(bestandsId: String) =
        documentInhoudRepository.findById(toDocumentInhoudId(bestandsId))
            ?: error("Document inhoud not found: $bestandsId")

    private fun toDocumentInhoudId(bestandsId: String) =
        bestandsId.substringAfter(BESTANDS_ID_PREFIX).toLong()
}

private fun DocumentVormEntity.toDocumentVorm() =
    DocumentVorm(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )

private fun DocumentStatusEntity.toDocumentStatus() =
    DocumentStatus(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )

fun DocumentTypeEntity.toDocumenttype() =
    Documenttype(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        documentcategorie = documentcategorie,
        publicatieniveau = when (publicatieniveau) {
            DocumentPublicatieniveauEnum.EXTERN -> DocumentPublicatieniveau.extern
            DocumentPublicatieniveauEnum.INTERN -> DocumentPublicatieniveau.intern
            DocumentPublicatieniveauEnum.VERTROUWELIJK -> DocumentPublicatieniveau.vertrouwelijk
        }
    )

private fun DocumentVersieEntity.toDocumentversie(documentInhoudEntity: DocumentInhoudEntity) =
    Documentversie(
        versienummer = versienummer,
        documentInhoudID = documentInhoudEntity.identifier,
        documentgrootte = if (documentInhoudEntity.documentgrootte > 0) documentInhoudEntity.documentgrootte else null,
        compressed = documentInhoudEntity.compressed,
        creatiedatum = creatiedatum,
        auteur = auteur,
        afzender = afzender,
        bestandsnaam = bestandsnaam,
        mimetype = mimetype,
        ondertekeningen = ondertekeningen.map { it.toDocumentOndertekening() }.ifEmpty { null },
    )

private fun MetadataelementEntity.toMetadataelement() =
    MetadataElement(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        label = label,
        type = DocumentMetadataElementType.valueOf(type.lowercase()),
        indicatieVerplicht = indicatieVerplicht,
        indicatieVoorAlleDocumenttypes = indicatieVoorAlleDocumenttypes,
    )

private fun DocumenthistorieEntity.toDocumentHistorie() =
    Documenthistorie(
        wijzigingDatum = datumwijziging,
        gewijzigdDoor = gewijzigddoor,
        oudeWaarde = oudewaarde,
        nieuweWaarde = nieuwewaarde,
        toelichting = toelichting,
        typeWijziging = typeWijziging,
    )

private fun DocumentPublicatieEntity.toDocumentPublicatie() =
    DocumentPublicatie(
        publicatiedatum = publicatiedatum,
    )

private fun TaalEntity.toTaal() =
    Taal(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        functioneelId = functioneelId,
    )

private fun DocumentOndertekeningEntity.toDocumentOndertekening() =
    DocumentOndertekening(
        documentTitel = documentTitel,
        ondertekenaar = ondertekenaar,
        ondertekenDatum = ondertekenDatum.toZonedDateTime(),
        creatieDatum = creatieDatum,
        opmerking = opmerking,
        gemandateerd = gemandateerd,
    )

