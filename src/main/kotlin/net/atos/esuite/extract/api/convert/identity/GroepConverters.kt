package net.atos.esuite.extract.api.convert.identity

import net.atos.esuite.extract.api.model.identity.Groep
import net.atos.esuite.extract.api.model.identity.GroepOverzicht
import net.atos.esuite.extract.db.entity.identity.GroepEntity

fun GroepEntity.toGroepOverzicht() = GroepOverzicht(
    naam = naam,
)

fun GroepEntity.toGroep() = Groep(
    naam = naam,
    code = code,
    omschrijving = omschrijving,
    groepshoofd = groepshoofd?.gebruikersnaam,
    emailadres = email,
    actief = actief,
    medewerkers = medewerkers.map { it.gebruikersnaam }.toSet(),
)
