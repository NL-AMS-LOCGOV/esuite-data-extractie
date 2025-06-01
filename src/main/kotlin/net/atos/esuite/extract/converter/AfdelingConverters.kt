package net.atos.esuite.extract.converter

import net.atos.esuite.extract.entity.identity.AfdelingEntity
import net.atos.esuite.extract.entity.identity.GroepEntity
import net.atos.esuite.extract.model.Afdeling
import net.atos.esuite.extract.model.AfdelingOverzicht
import net.atos.esuite.extract.model.Groep
import net.atos.esuite.extract.model.GroepOverzicht

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
