package net.atos.esuite.extract.convert.identity

import net.atos.esuite.extract.api.model.identity.Afdeling
import net.atos.esuite.extract.api.model.identity.AfdelingOverzicht
import net.atos.esuite.extract.db.entity.identity.AfdelingEntity

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
