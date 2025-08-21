package net.atos.esuite.extract.api.model.basisgegevens

enum class AdresType {

    // Correspondentie adres van zowel een persoon of een bedrijf ('C')
    correspondentie_adres,

    // Persoon is hier permanent ingeschreven ('I')
    inschrijf_adres_persoon,

    // Persoon verblijft hier ('V')
    verblijf_adres_persoon,

    // Post adres voor bedrijven ('P')
    post_adres_bedrijf,

    // Vestigingsadres voor bedrijven ('S')
    vestigings_adres_bedrijf,
}
