package net.atos.esuite.extract.repository.identity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.identity.MedewerkerEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class MedewerkerRepository : PanacheRepository<MedewerkerEntity> {

    fun findByGebruikersnaam(gebruikersnaam: String) = find("gebruikersnaam", gebruikersnaam).firstResult()

    fun listAll(pageIndex: Int, pageSize: Int) =
        ListResult(
            findAll().page(pageIndex, pageSize).list(),
            count().toInt()
        )
}
