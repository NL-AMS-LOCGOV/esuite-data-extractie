package net.atos.esuite.extract.api.convert

import net.atos.esuite.extract.api.model.shared.Kanaal
import net.atos.esuite.extract.db.configuratiemagazijn.entity.KanaalEntity

fun KanaalEntity.toKanaal() =
    Kanaal(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )
