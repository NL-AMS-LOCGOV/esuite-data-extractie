package net.atos.esuite.extract.api.convert.zaak

import net.atos.esuite.extract.api.convert.document.toDocumenttype
import net.atos.esuite.extract.api.convert.shared.toLocalDate
import net.atos.esuite.extract.api.model.document.DocumentTag
import net.atos.esuite.extract.api.model.document.DocumentTitel
import net.atos.esuite.extract.api.model.taak.TaakDocument
import net.atos.esuite.extract.api.model.taak.TaakDocumentGroep
import net.atos.esuite.extract.api.model.zaaktype.*
import net.atos.esuite.extract.db.zakenmagazijn.entity.*


fun ZaakTypeEntity.toZaaktypeOverzicht() = ZaaktypeOverzicht(
    naam = naam,
    functioneleIdentificatie = functioneelId,
    omschrijving = omschrijving,
    actief = actief,
)

fun ZaakTypeEntity.toZaaktype() = Zaaktype(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
    functioneleIdentificatie = functioneelId,
    handelingInitiator = handelingInitiator.toHandelingInitiator(),
    internExtern = when (internExtern) {
        InternExternEnum.INTERN -> InternExtern.intern
        InternExternEnum.EXTERN -> InternExtern.extern
    },
    categorie = categorie.toCategorie(),
    iv3categorie = iv3categorie.toIv3Categorie(),
    afdeling = idInitieleAfdeling,
    groep = idInitieleGroep,
    intake = indicatieIntake,
    beginGeldigheidDatum = beginGeldigheid.toLocalDate(),
    eindeGeldigheidDatum = eindeGeldigheid?.toLocalDate(),
    doorlooptijdGewenst = doorlooptijdGewenst,
    doorlooptijdVereist = doorlooptijdVereist,
    doorlooptijdAanpassenToegestaan = indicatieDoorlooptijdAanpassenToegestaan,
    aantalDagenVoorStreefdatumVoorEersteSignalering = aantalDagenVoorStreefdatumVoorEersteSignalering,
    aantalDagenVoorStreefdatumVoorTweedeSignalering = aantalDagenVoorStreefdatumVoorTweedeSignalering,
    aantalDagenVoorFataledatumVoorEersteSignalering = aantalDagenVoorFataledatumVoorEersteSignalering,
    aantalDagenVoorFataledatumVoorTweedeSignalering = aantalDagenVoorFataledatumVoorTweedeSignalering,
    status = initieleStatus?.toZaakstatus(),
    archiveringReviewPeriode = archiveringReviewPeriodeInWeken,
    startenProces = startenProces,
    proces = fidProces,
    startformulier = fidFormulierdefinitie,
    startformulierVersie = fidFormulierdefinitieVersie,
    vertrouwelijk = indVertrouwelijk,
    authenticaties = zaakTypeAuthenticaties.map { it.toZaaktypeAuthenticatie() }.ifEmpty { null },
    geautoriseerdVoorMedewerkers = autorisatie,
    geautoriseerdeMedewerkers = geautoriseerdeMedewerkers,
    notificatiesVersturen = notificatiesVersturen,
    statussen = zaakStatussen.map { it.toZaakstatus() }.ifEmpty { null },
    resultaten = zaakTypeZaakResultaten.map { it.toZaaktypeResultaat() }.ifEmpty { null },
    besluiten = zaakTypeBesluittypen.map { it.toZaaktypeBesluittype() }.ifEmpty { null },
    documenttypen = zaakTypeDocumentTypen.map { it.toZaaktypeDocumenttype() }.ifEmpty { null },
    documentTags = zaakTypeTags.map { it.tag.toDocumentTag() }.ifEmpty { null },
    gekoppeldeZaaktypen = gekoppeldeZaaktypes.map { it.toZaaktypeOverzicht() }.ifEmpty { null },
    taakDocumentGroepen = taakDocumentGroepen.map { it.toTaakDocumentGroep() }.ifEmpty { null },
    samenvattingDocumentNaam = samenvattingDocumentNaam,
    zaakStartParameters = zaakStartParameters.map { it.toZaakStartParameter() }.ifEmpty { null },
    productaanvraagtype = productaanvraagtype,
)

private fun HandelingInitiatorEntity.toHandelingInitiator() =
    HandelingInitiator(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )

private fun CategorieEntity.toCategorie() =
    Categorie(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )

private fun Iv3CategorieEntity.toIv3Categorie() =
    Iv3Categorie(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        externeCode = externeCode,
    )

private fun ZaakTypeAuthenticatieEntity.toZaaktypeAuthenticatie() =
    ZaaktypeAuthenticatie(
        doelgroep = when (doelgroep) {
            ZaakTypeDoelgroepEnum.BURGER -> AuthenticatieDoelgroep.burger
            ZaakTypeDoelgroepEnum.BEDRIJF -> AuthenticatieDoelgroep.bedrijf
        },
        niveau = when (authenticatieNiveau) {
            "NONE" -> AuthenticatieNiveau.none
            "DIG1" -> AuthenticatieNiveau.digid_1
            "DIG2" -> AuthenticatieNiveau.digid_2
            "DIG3" -> AuthenticatieNiveau.digid_3
            "DIG4" -> AuthenticatieNiveau.digid_4
            "EHE1" -> AuthenticatieNiveau.eherkenning_1
            "EHE2" -> AuthenticatieNiveau.eherkenning_2
            "EHE3" -> AuthenticatieNiveau.eherkenning_3
            "EHE4" -> AuthenticatieNiveau.eherkenning_4
            "EHE5" -> AuthenticatieNiveau.eherkenning_5
            else -> error("Invalid AuthenticatieNiveau: $authenticatieNiveau")
        }
    )

private fun ZaakTypeZaakResultaatEntity.toZaaktypeResultaat() =
    ZaaktypeResultaat(
        resultaat = resultaat.toResultaat(),
        selectielijstitem = selectielijstitem.toSelectielijstitem(),
        bewaartermijnWaardering = waardering?.toBewaartermijnWaardering(),
        bewaartermijn = bewaartermijnInMaanden,
        bewaartermijnEenheid = toonbareBewaartermijnEenheid?.toBewaartermijnEenheid(),
    )

private fun SelectielijstitemEntity.toSelectielijstitem() =
    Selectielijstitem(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        jaar = jaar,
        domein = domein,
        subdomein = subdomein,
        bewaartermijnWaardering = waardering?.toBewaartermijnWaardering(),
        bewaartermijn = bewaartermijnInMaanden,
        bewaartermijnEenheid = toonbareBewaartermijnEenheid?.toBewaartermijnEenheid(),
    )


private fun String.toBewaartermijnEenheid() =
    when (this) {
        "MAANDEN" -> BewaartermijnEenheid.maanden
        "JAREN" -> BewaartermijnEenheid.jaren
        else -> error("Invalid BewaartermijnEenheid: $this")
    }

private fun ZaakTypeBesluittypeEntity.toZaaktypeBesluittype() =
    ZaaktypeBesluittype(
        besluittype = besluittype.toBesluittype(),
        documenttype = documentType?.toDocumenttype(),
        procestermijn = procestermijnInMaanden,
    )

private fun ZaakTypeDocumentTypeEntity.toZaaktypeDocumenttype() =
    ZaaktypeDocumenttype(
        documenttype = documentType.toDocumenttype(),
        dspcode = dspcode,
        titels = documentTitelKoppelingen.map { it.documentTitel.toDocumentTitel() }.ifEmpty { null },
    )

private fun DocumentTitelEntity.toDocumentTitel() =
    DocumentTitel(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )

private fun TagEntity.toDocumentTag() =
    DocumentTag(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )

private fun TaakDocumentGroepEntity.toTaakDocumentGroep() =
    TaakDocumentGroep(
        naam = functioneleNaam,
        taakDocumenten = taakDocumenten.map { it.toTaakDocument() }.ifEmpty { null },
    )

private fun TaakDocumentEntity.toTaakDocument() =
    TaakDocument(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
        documentNaam = documentNaam,
        documentTemplate = documentTemplate,
        templateGroep = templateGroep,
        documenttype = documentType?.toDocumenttype(),
    )

private fun ZaakStartParameterEntity.toZaakStartParameter() =
    ZaakStartParameter(
        naam = naam,
        type = type,
    )
