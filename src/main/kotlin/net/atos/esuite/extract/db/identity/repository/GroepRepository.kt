package net.atos.esuite.extract.db.identity.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.identity.entity.GroepEntity

@ApplicationScoped
class GroepRepository : PanacheRepository<GroepEntity> {

    fun findByNaam(naam: String) = find("naam", naam).firstResult()
}
