package net.atos.esuite.extract.api.model.subject

enum class Vestigingsstatus {

    /** De vestiging is nieuw in het Handelsregister */
    nieuw_in_handelsregister,

    /** De vestiging is nieuw voor de profielhouder, maar bestond al in het Handelsregister */
    nieuw_voor_profielhouder,

    /** De vestiging is gewijzigd */
    vestiging_is_gewijzigd,

    /** De vestiging vervalt voor de profielhouder, maar blijft bestaan in het Handelsregister */
    vervalt_voor_profielhouder_blijft_in_handelsregister,

    /** De vestiging heeft de status ‘opgeheven’ gekregen */
    opgeheven,

    /** De status ‘opgeheven’ is ongedaan gemaakt */
    opgeheven_ongedaan_gemaakt,

    /** De vestiging is opgeheven om ergens anders opnieuw te beginnen */
    opgeheven_ergens_anders_opnieuw,
}
