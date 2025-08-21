package net.atos.esuite.extract.api.model.zaak

enum class ZaakHistorieTypeWijziging {

    /** Wijziging door overdracht  */
    overdragen,

    /** Wijziging door overbrengen  */
    overbrengen,

    /** Status wijziging  */
    status,

    /** Kanaal wijziging  */
    kanaal,

    /** Streefdatum wijziging  */
    streefdatum,

    /** Wijziging van de startDatum  */
    startdatum,

    /** Wijziging van de fataleDatum  */
    fataledatum,

    /** Vertrouwelijkheid wijziging  */
    vertrouwelijkheid,

    /** Wijziging van de zaak omschrijving  */
    zaak_omschrijving,

    /** Wijziging reden startzaak  */
    reden_starten_zaak,

    /** Archiveren  */
    verlenging_bewaartermijn,

    /** Wijzinging review termijn  */
    reviewtermijn,

    /** Wijzinging dmv overdracht van de zaak (SSA = semi statisch archief)  */
    overdragen_ssa,

    /** Wijzinging dmv overbrengen van de zaak  */
    overbrengen_extern,

    /** Wijziging dmv heropening zaak.  */
    heropenen_zaak,

    /** Document toegevoegd  */
    nieuw_document,

    /** Document van zaak ontkoppeld  */
    document_ontkoppeld,

    /** Document volledig verwijderd  */
    document_verwijderd,

    /** Document is geunlocked  */
    document_unlocked,

    /** Aanvrager gewijzigd  */
    aanvrager,

    /** Betrokkene toegevoegd of ontkoppeld  */
    betrokkenen,

    /** Resultaat van zaak gewijzigd  */
    zaakresultaat,

    /** Status update van de betaling  */
    ogone_post_sale,

    /** Ingangsdatum van een besluit is gewijzigd  */
    ingangsdatum_besluit,

    /** Vervaldatum van een besluit is gewijzigd  */
    vervaldatum_besluit,

    /** Bewaartermijn van zaak is gewijzigd  */
    bewaartermijn,

    /** Opschorttermijn is gewijzigd  */
    opschorttermijn,

    /** Autorisatie is gewijzigd  */
    autorisatie,

    /** Organisatie is gewijzigd  */
    organisatie,

    /** Gefaalde ProcesStap is handmatig gestart  */
    proces_herstarten,

    /** De betaling is verwerkt in ogone  */
    betaling_verwerkt,

    /** (Ont)koppelen van een BAG-object  */
    bag_koppeling,

    /** (Ont)koppelen van een zaak  */
    zaak_koppeling,

    /** (Ont)koppelen van een contact  */
    contact_koppeling,

    /** Intrekken of uitzetten van een Externe Taak  */
    externe_taak,

    /** Intrekken of uitzetten van een Externe Taak Ketenpartner  */
    externe_taak_ketenpartner,

    /** Locatie van de zaak */
    locatie,

    /** Notitie  */
    notitie,

    /** Zaaktype  */
    zaaktype,

    /** Document status  */
    document_status,

    /** Meta data element  */
    metadataelement,

    // Document type
    documenttype;
}
