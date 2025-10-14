package net.atos.esuite.extract.api.convert

import net.atos.esuite.extract.api.model.identity.*
import net.atos.esuite.extract.db.identity.entity.*

fun MedewerkerEntity.toMedewerkerOverzicht() = MedewerkerOverzicht(
    gebruikersnaam = gebruikersnaam,
    volledigeNaam = naam,
)

fun MedewerkerEntity.toMedewerker() = Medewerker(
    gebruikersnaam = gebruikersnaam,
    volledigeNaam = naam,
    telefoonnummer = telefoon,
    emailadres = email,
    actief = actief,
    indiensttredingDatum = indiensttredingDatum,
    uitdiensttredingDatum = uitdiensttredingDatum,
    externeNaam = externeNaam,
    functie = functie?.toFunctie(),
    geslacht = when (geslacht) {
        "M" -> GeslachtMedewerker.man
        "V" -> GeslachtMedewerker.vrouw
        else -> error("Invalid geslacht: $geslacht")
    },
    opmerkingen = opmerkingen,
    primaireAfdeling = primaireAfdeling?.naam,
    afdelingen = afdelingen.map { it.naam }.toSet(),
    groepen = groepen.map { it.naam }.toSet(),
    afdelingshoofdVan = afdelingen.filter { it.afdelingshoofd?.naam == naam }.map { it.naam }.toSet(),
    groepshoofdVan = groepen.filter { it.groepshoofd?.naam == naam }.map { it.naam }.toSet(),
    rollen = rollen.map { it.toRol() }.toSet(),
    rechten = rollen.flatMap { it.rechten.map { rechtEntity -> rechtEntity.toRecht() } }
        .distinctBy { recht -> recht.naam }
        .toSet()
)


private fun FunctieEntity.toFunctie() = Functie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)

private fun RolEntity.toRol() = Rol(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)

private fun RechtEntity.toRecht() = Recht(
    naam = naam,
    actief = actief,
    categorie = categorie,
    waarde = waarde?.let { RechtWaarde(it) },
    operatie = RechtOperatie.valueOf(operatie.lowercase()),
    type = RechtType.valueOf(type.lowercase()),
)


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
