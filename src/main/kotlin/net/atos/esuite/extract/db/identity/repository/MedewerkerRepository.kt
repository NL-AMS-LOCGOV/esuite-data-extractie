package net.atos.esuite.extract.db.identity.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.identity.entity.MedewerkerEntity

@ApplicationScoped
class MedewerkerRepository : PanacheRepository<MedewerkerEntity> {

    fun findByGebruikersnaam(gebruikersnaam: String) = find("gebruikersnaam", gebruikersnaam).firstResult()
}
