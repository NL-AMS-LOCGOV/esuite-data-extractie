package net.atos.esuite.extract.db.identity.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.identity.entity.AfdelingEntity

@ApplicationScoped
class AfdelingRepository : PanacheRepository<AfdelingEntity> {

    fun findByNaam(naam: String) = find("naam", naam).firstResult()
}
