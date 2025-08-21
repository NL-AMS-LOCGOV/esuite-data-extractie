package net.atos.esuite.extract.db.repository.identity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.identity.MedewerkerEntity
import net.atos.esuite.extract.db.util.ListResult

@ApplicationScoped
class MedewerkerRepository : PanacheRepository<MedewerkerEntity> {

    fun findByGebruikersnaam(gebruikersnaam: String) = find("gebruikersnaam", gebruikersnaam).firstResult()

    fun listAll(pageIndex: Int, pageSize: Int) =
        ListResult(
            findAll().page(pageIndex, pageSize).list(),
            count().toInt()
        )
}
