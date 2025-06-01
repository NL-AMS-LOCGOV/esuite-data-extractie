package net.atos.esuite.extract.converter

import net.atos.esuite.extract.entity.identity.FunctieEntity
import net.atos.esuite.extract.entity.identity.MedewerkerEntity
import net.atos.esuite.extract.entity.identity.RechtEntity
import net.atos.esuite.extract.entity.identity.RolEntity
import net.atos.esuite.extract.model.Functie
import net.atos.esuite.extract.model.GeslachtMedewerker
import net.atos.esuite.extract.model.Medewerker
import net.atos.esuite.extract.model.MedewerkerOverzicht
import net.atos.esuite.extract.model.Recht
import net.atos.esuite.extract.model.RechtOperatie
import net.atos.esuite.extract.model.RechtType
import net.atos.esuite.extract.model.RechtWaarde
import net.atos.esuite.extract.model.Rol

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
    locked = afgesloten,
    externeNaam = externeNaam,
    functie = functie?.toFunctie(),
    geslacht = when (geslacht) {
        "M" -> GeslachtMedewerker.man
        "V" -> GeslachtMedewerker.vrouw
        else -> error("Invalid geslacht: $geslacht")
    },
    laatsteLoginDatumTijd = laatsteLogonTijd?.toZonedDateTime(),
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

