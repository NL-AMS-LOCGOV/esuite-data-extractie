package net.atos.esuite.extract.model

import java.net.URI

class ZaakResults(
    val count: Int,

    val next: URI?,

    val previous: URI?,

    val results: List<ZaakOverzicht>,
    )
