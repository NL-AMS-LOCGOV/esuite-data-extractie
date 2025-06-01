package net.atos.esuite.extract.converter.identity

import net.atos.esuite.extract.entity.identity.GroepEntity
import net.atos.esuite.extract.model.identity.Groep
import net.atos.esuite.extract.model.identity.GroepOverzicht

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
