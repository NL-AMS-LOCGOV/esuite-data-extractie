package net.atos.esuite.extract.api.convert.shared

import net.atos.esuite.extract.api.model.shared.Kanaal
import net.atos.esuite.extract.db.entity.configuratiemagazijn.ReferentieKanaalEntity

fun ReferentieKanaalEntity.toKanaal() =
    Kanaal(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )
