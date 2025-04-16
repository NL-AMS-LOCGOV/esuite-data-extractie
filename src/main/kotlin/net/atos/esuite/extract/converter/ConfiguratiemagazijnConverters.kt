package net.atos.esuite.extract.converter

import net.atos.esuite.extract.entity.configuratiemagazijn.ReferentieKanaalEntity
import net.atos.esuite.extract.model.Kanaal

fun ReferentieKanaalEntity.toKanaal() =
    Kanaal(
        naam = naam,
        omschrijving = omschrijving,
    )
