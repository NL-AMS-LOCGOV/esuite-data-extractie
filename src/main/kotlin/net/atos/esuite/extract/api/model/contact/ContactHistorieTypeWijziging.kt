package net.atos.esuite.extract.api.model.contact

enum class ContactHistorieTypeWijziging {
    /** Wijzigen van aanvrager  */
    aanvrager,

    /** Wijziging door overdracht  */
    overdragen,

    /** Status wijziging  */
    status,

    /** Prioriteit wijziging  */
    prioriteit,

    /** Kanaal wijziging  */
    kanaal,

    /** Streefdatum wijziging  */
    streefdatum,

    /** Contacttype wijziging  */
    contacttype,

    /** Vertrouwelijkheid wijziging  */
    vertrouwelijkheid,

    /** Vraag gewijzigd  */
    vraag,

    /** Antwoord gewijzigd  */
    antwoord,

    /** Antwoord Verzonden via mail  */
    email_verzonden,

    /** Emailadres wijziging  */
    emailadres,

    /** Telefoonnummer wijziging  */
    telefoonnummer,

    /** Telefoonnummer alternatief wijziging  */
    telefoonnummer_alternatief,

    /** (Ont)koppelen van een BAG-object  */
    bag_koppeling,

    /** (Ont)koppelen van een domeinobject  */
    dsr_koppeling,

    /** (Ont)koppelen van een contact  */
    contact_koppeling,

    /** (Ont)koppelen van een zaak  */
    zaak_koppeling
}
