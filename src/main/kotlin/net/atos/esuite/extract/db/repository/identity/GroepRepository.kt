package net.atos.esuite.extract.db.repository.identity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.identity.GroepEntity

@ApplicationScoped
class GroepRepository : PanacheRepository<GroepEntity> {

    fun findByNaam(naam: String) = find("naam", naam).firstResult()
}
