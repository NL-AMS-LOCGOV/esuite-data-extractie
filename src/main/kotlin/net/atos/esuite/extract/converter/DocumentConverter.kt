package net.atos.esuite.extract.converter

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.zakenmagazijn.DocumentEntity
import net.atos.esuite.extract.entity.zakenmagazijn.DocumentPublicatieniveau
import net.atos.esuite.extract.entity.zakenmagazijn.DocumentRichting
import net.atos.esuite.extract.entity.zakenmagazijn.DocumentVersturen
import net.atos.esuite.extract.model.Document
import net.atos.esuite.extract.repository.DocumentStatusRepository
import net.atos.esuite.extract.repository.DocumentTypeRepository
import net.atos.esuite.extract.repository.DocumentVormRepository
import net.atos.esuite.extract.repository.TaalRepository
import net.atos.esuite.extract.repository.ZaakRepository.Companion.ZAAKTYPE_ID_PREFIX

@ApplicationScoped
class DocumentConverter(
    private val documentTypeRepository: DocumentTypeRepository,
    private val documentStatusRepository: DocumentStatusRepository,
    private val documentVormRepository: DocumentVormRepository,
    private val taalRepository: TaalRepository,
) {
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
                DocumentPublicatieniveau.EXTERN -> net.atos.esuite.extract.model.DocumentPublicatieniveau.extern
                DocumentPublicatieniveau.INTERN -> net.atos.esuite.extract.model.DocumentPublicatieniveau.intern
                DocumentPublicatieniveau.VERTROUWELIJK -> net.atos.esuite.extract.model.DocumentPublicatieniveau.vertrouwelijk
            },
            documentVersturen = when (documentEntity.documentVersturen) {
                DocumentVersturen.IS_VERSTUURD -> net.atos.esuite.extract.model.DocumentVersturen.is_verstuurd
                DocumentVersturen.MOET_NIET_VERSTUURD_WORDEN -> net.atos.esuite.extract.model.DocumentVersturen.moet_niet_verstuurd_worden
            },
            documentVersturenDatum = documentEntity.documentVersturenDatum,
            isAanvraagDocument = documentEntity.indAanvraag,
            ontvangstDatum = if (documentEntity.documentrichting == DocumentRichting.INKOMEND) documentEntity.ontvangstverzendcreatiedatum else null,
            verzendDatum = if (documentEntity.documentrichting == DocumentRichting.UITGAAND) documentEntity.ontvangstverzendcreatiedatum else null,
            documentrichting = when (documentEntity.documentrichting) {
                DocumentRichting.INKOMEND -> net.atos.esuite.extract.model.DocumentRichting.inkomend
                DocumentRichting.UITGAAND -> net.atos.esuite.extract.model.DocumentRichting.uitgaand
                DocumentRichting.INTERN -> net.atos.esuite.extract.model.DocumentRichting.intern
            },
            locatie = documentEntity.locatie,
            beschrijving = documentEntity.beschrijving,
            lockEigenaarId = documentEntity.lockEigenaarId,
            lockDatumTijd = documentEntity.lockDatumTijd?.toZonedDateTime(),
            documentversies = documentEntity.documentversies.map { it.toDocumentversie() },
            documentMetadata = documentEntity.documentMetadata.map { it.toDocumentMetadata() }.ifEmpty { null },
            taak = documentEntity.taak?.toTaak(),
            historie = documentEntity.historie.map { it.toDocumentHistorie() },
            publicaties = documentEntity.publicaties.map { it.toDocumentPublicatie() }.ifEmpty { null },
            pdfaId = documentEntity.pdfaId,
            pdfaDocumentversie = documentEntity.pdfaDocumentVersieEntity?.toDocumentversie(),
            taal = documentEntity.taalId?.let { toTaal(it) },
            geautoriseerdeMedewerkers = documentEntity . geautoriseerdeMedewerkers . ifEmpty { null },
            isGeautoriseerdVoorMedewerkers = documentEntity.autorisatie,
            converterenNaarPdfa = documentEntity.converterenNaarPdfa,
        )

    private fun toDocumentVorm(documentVormId: String) =
        documentVormRepository.findById(documentVormId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toDocumentVorm()
            ?: error("Document vorm id not found: $documentVormId")

    private fun toDocumentStatus(documentStatusID: String) =
        documentStatusRepository.findById(documentStatusID.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toDocumentStatus()
            ?: error("Document status id not found: $documentStatusID")

    private fun toDocumenttype(documenttypeId: String) =
        documentTypeRepository.findById(documenttypeId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toDocumenttype()
            ?: error("Document type id not found: $documenttypeId")

    private fun toTaal(taalId: String) =
        taalRepository.findById(taalId.substringAfter(ZAAKTYPE_ID_PREFIX).toLong())
            ?.toTaal()
            ?: error("Taal with id $taalId not found")
}
