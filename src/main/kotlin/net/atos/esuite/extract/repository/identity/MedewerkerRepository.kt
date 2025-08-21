package net.atos.esuite.extract.repository.identity

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.identity.MedewerkerEntity
import net.atos.esuite.extract.repository.BaseRepository

@ApplicationScoped
class MedewerkerRepository : BaseRepository<MedewerkerEntity> {

    fun findByGebruikersnaam(gebruikersnaam: String) : MedewerkerEntity? =
        find("gebruikersnaam", gebruikersnaam).firstResult()
}
