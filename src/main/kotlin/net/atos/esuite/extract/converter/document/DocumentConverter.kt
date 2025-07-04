package net.atos.esuite.extract.converter.document

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.converter.zaak.toTaak
import net.atos.esuite.extract.converter.toZonedDateTime
import net.atos.esuite.extract.entity.zakenmagazijn.DocumentEntity
import net.atos.esuite.extract.entity.zakenmagazijn.DocumentMetadataEntity
import net.atos.esuite.extract.entity.zakenmagazijn.DocumentPublicatieniveau
import net.atos.esuite.extract.entity.zakenmagazijn.DocumentRichting
import net.atos.esuite.extract.entity.zakenmagazijn.DocumentVersturen
import net.atos.esuite.extract.model.document.Document
import net.atos.esuite.extract.model.document.DocumentMetadata
import net.atos.esuite.extract.repository.document.DocumentInhoudRepository
import net.atos.esuite.extract.repository.document.DocumentStatusRepository
import net.atos.esuite.extract.repository.document.DocumentTypeRepository
import net.atos.esuite.extract.repository.document.DocumentVormRepository
import net.atos.esuite.extract.repository.document.MetadataelementRepository
import net.atos.esuite.extract.repository.document.TaalRepository
import net.atos.esuite.extract.repository.zaak.ZaakRepository.Companion.ZAAKTYPE_ID_PREFIX

@ApplicationScoped
class DocumentConverter(
    private val documentTypeRepository: DocumentTypeRepository,
    private val documentStatusRepository: DocumentStatusRepository,
    private val documentVormRepository: DocumentVormRepository,
    private val taalRepository: TaalRepository,
    private val metadataelementRepository: MetadataelementRepository,
    private val documentInhoudRepository: DocumentInhoudRepository,
) {
    companion object {
        const val BESTANDS_ID_PREFIX = "dms:"
    }

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
                DocumentPublicatieniveau.EXTERN -> net.atos.esuite.extract.model.document.DocumentPublicatieniveau.extern
                DocumentPublicatieniveau.INTERN -> net.atos.esuite.extract.model.document.DocumentPublicatieniveau.intern
                DocumentPublicatieniveau.VERTROUWELIJK -> net.atos.esuite.extract.model.document.DocumentPublicatieniveau.vertrouwelijk
            },
            documentVersturen = when (documentEntity.documentVersturen) {
                DocumentVersturen.IS_VERSTUURD -> net.atos.esuite.extract.model.document.DocumentVersturen.is_verstuurd
                DocumentVersturen.MOET_NIET_VERSTUURD_WORDEN -> net.atos.esuite.extract.model.document.DocumentVersturen.moet_niet_verstuurd_worden
            },
            documentVersturenDatum = documentEntity.documentVersturenDatum,
            aanvraagDocument = documentEntity.indAanvraag,
            ontvangstDatum = if (documentEntity.documentrichting == DocumentRichting.INKOMEND) documentEntity.ontvangstverzendcreatiedatum else null,
            verzendDatum = if (documentEntity.documentrichting == DocumentRichting.UITGAAND) documentEntity.ontvangstverzendcreatiedatum else null,
            documentrichting = when (documentEntity.documentrichting) {
                DocumentRichting.INKOMEND -> net.atos.esuite.extract.model.document.DocumentRichting.inkomend
                DocumentRichting.UITGAAND -> net.atos.esuite.extract.model.document.DocumentRichting.uitgaand
                DocumentRichting.INTERN -> net.atos.esuite.extract.model.document.DocumentRichting.intern
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
