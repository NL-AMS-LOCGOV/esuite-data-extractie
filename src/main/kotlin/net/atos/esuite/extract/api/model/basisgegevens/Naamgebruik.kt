package net.atos.esuite.extract.api.model.basisgegevens

enum class Naamgebruik {

    // ('E')
    eigen_geslachtsnaam,

    // Achternaam partner na eigen ('N')
    geslachtsnaam_partner_na_eigen_geslachtsnaam,

    // Alleen achternaam partner ('P')
    geslachtsnaam_partner,

    // Eigen achternaam na achternaam partner ('V')
    geslachtsnaam_partner_voor_eigen_geslachtsnaam,
}
