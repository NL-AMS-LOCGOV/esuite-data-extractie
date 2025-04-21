package net.atos.esuite.extract.model

class ZaakResults(

    val count: Int,

    val nextPage: Int?,

    val previousPage: Int?,

    val results: List<ZaakOverzicht>,
    )
