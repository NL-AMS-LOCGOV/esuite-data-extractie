package net.atos.esuite.extract.converter

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity_.id
import net.atos.esuite.extract.entity.identity.MedewerkerEntity
import net.atos.esuite.extract.model.ContactHistorieTypeWijziging
import net.atos.esuite.extract.model.Medewerker

fun MedewerkerEntity.toMedewerker() = Medewerker(
    gebruikersnaam = medewerkernaam,
    volledigeNaam = naam,
    telefoonnummer = telefoon,
    emailadres = email,
)

