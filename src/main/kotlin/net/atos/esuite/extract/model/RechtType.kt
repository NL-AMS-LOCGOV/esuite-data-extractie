package net.atos.esuite.extract.model

enum class RechtType {
    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op PERSOONS gegevens.
     */
    persoonsgegevens,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op externe persoons gegevens.
     */
    persoonsgegevens_extern,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op handmatig toegevoegde persoons gegevens.
     */
    persoonsgegevens_handmatig,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op externe buitengemeentelijke persoons gegevens.
     */
    buitengemeentelijke_persoonsgegevens_extern,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op BEDRIJFS gegevens.
     */
    bedrijfsgegevens,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op Externe BEDRIJFS gegevens.
     */
    bedrijfsgegevens_extern,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op handmatig toegevoegde bedrijfs gegevens.
     */
    bedrijfsgegevens_handmatig,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op de bewaartermijn van een zaak.
     */
    bewaartermijn,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op CONTACT gegevens.
     */
    contact,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op ZAAK gegevens. Dit recht wordt specifiek per zaaktype gecontroleerd
     */
    zaak,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op VOORLOPIG_ANTWOORD_VAN_CONTACT gegevens
     */
    voorlopig_antwoord_van_contact,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op GEGEVENS_VOOR_ARCHIVERING gegevens
     */
    gegevens_voor_archivering,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op NOTITIE gegevens
     */
    notities,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op VERTROUWELIJKE DOCUMENTEN data. Dit recht wordt specifiek per zaaktype gecontroleerd
     */
    vertrouwelijk_document,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op BETROKKENE AAN ZAAK gegevens
     */
    betrokkene_aan_zaak,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op het tabblad KCC
     */
    tabblad_kcc,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op het tabblad werklijsten
     */
    tabblad_werklijsten,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op het tabblad beheer
     */
    tabblad_beheer,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op het tabblad overzichten
     */
    tabblad_overzichten,


    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op alle geplande overzichten
     */
    alle_geplande_overzichten,


    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op BAG OBJECT gegevens
     */
    bag_object_gegevens,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op INBOX DOCUMENTEN
     */
    inbox_documenten,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op alle AFSPRAKEN gegevens.
     */
    alle_afspraken,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op AFSPRAAK gegevens.
     */
    afspraak,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren binnen het beheer gedeelte van de RAPPORTAGEMODULE.
     */
    beheer_rapportagemodule,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren binnen het beheer gedeelte van de AFSPRAKENMODULE.
     */
    beheer_afsprakenmodule,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op AFSPRAKEN RESOURCEPOOL gegevens.
     */
    afspraken_resourcepool,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren binnen het beheer gedeelte van de ZAAKTYPECATALOGUS.
     */
    beheer_zaaktypecatalogus,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren binnen het beheer gedeelte van de DOMEINREGISTRATIE.
     */
    beheer_domeinregistratie,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren binnen het beheer gedeelte van de PARAMETERS.
     */
    beheer_parameters,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op alle ZAAKTYPES.
     */
    alle_zaaktypen,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op DOCUMENTEN.
     */
    document,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op DOCUMENTEN bij afgesloten ZAKEN.
     */
    document_bij_afgesloten_zaak,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op het DSR domein.
     */
    domein,

    /**
     * RechtType dat bepaalt of een gebruiker een bepaald veld uit de persoonsgegevens al dan niet mag zien
     */
    veldtoegang,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op afgehandelde zaken/documenten
     */
    recordmanagement,

    /**
     * RechtType dat bepaalt of een gebruiker operaties mag uitvoeren op geautoriseerde zaken/documenten
     */
    autorisatiemanagement,

    /**
     * Rechttype dat bepaalt of gebruiker een rapportage mag aanmaken
     */
    rapportage,

    /**
     * RechtType for Gebruikersbeheer link
     */
    tabblad_gebruikers,

    /**
     * Rechttype dat bepaalt of een gebruiker het Zgw APIs beheer mag zien
     */
    beheer_zgw_apis,

    /**
     * RechtType for Referentietabellen link
     */
    beheer_referentietabellen,

    /**
     * RechtType for Instellingen link
     */
    beheer_instellingen,

    /**
     * Rechttype dat bepaaalt of een gebruiker de berichten monitor mag zien
     */
    beheer_berichten_monitor,

    /**
     * Rechttype dat bepaalt of een gebruiker de vervaldatum van een besluit bij eenafgesloten zaak mag wijzigen
     */
    vervaldatum_besluit,

    /**
     * Rechttype dat bepaald of een gebruik de notitie van een zaak kan bewerken / verwijderen
     */
    notitie_bij_zaak,

    /**
     * Rechttype dat bepaald of een gebruik de notitie van een afgesloten zaak kan toevoegen
     */
    notitie_bij_afgesloten_zaak,

    /**
     * Rechttype dat bepaald of een gebruiker het zaaktype van een zaak mag omzetten
     */
    zaaktype_van_zaak,

    /**
     * Rechttype dat bepaalt of een gebruiker de informatiebeheer rol vervult.
     */
    archieflijst_informatiebeheer,

    /**
     * Rechttype dat bepaalt of een gebruiker de proceseigenaar rol vervult.
     */
    archieflijst_proceseigenaar,

    /**
     * Rechttype voor kwaliteitscontrolelijsten.
     */
    kwaliteitscontrolelijst,
}
