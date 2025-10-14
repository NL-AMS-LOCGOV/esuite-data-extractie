package net.atos.esuite.extract.db.zakenmagazijn.entity

enum class BetaalstatusEnum {

    /**
     * Betaling is geslaagd
     */
    GESLAAGD,

    /**
     * Betaling is niet geslaagd
     */
    NIET_GESLAAGD,

    /**
     * Betaling is in behandeling
     */
    IN_BEHANDELING,

    /**
     * Betaling is geannuleerd door gemeente
     */
    GEANNULEERD,
}
