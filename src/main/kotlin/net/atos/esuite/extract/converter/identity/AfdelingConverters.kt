package net.atos.esuite.extract.converter.identity

import net.atos.esuite.extract.entity.identity.AfdelingEntity
import net.atos.esuite.extract.model.identity.Afdeling
import net.atos.esuite.extract.model.identity.AfdelingOverzicht

fun AfdelingEntity.toAfdelingOverzicht() = AfdelingOverzicht(
    naam = naam,
)

fun AfdelingEntity.toAfdeling() = Afdeling(
    naam = naam,
    code = code,
    omschrijving = omschrijving,
    afdelingshoofd = afdelingshoofd?.gebruikersnaam,
    emailadres = email,
    actief = actief,
    medewerkers = medewerkers.map { it.gebruikersnaam }.toSet(),
)
