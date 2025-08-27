package net.atos.esuite.extract.db.repository.dsr

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.dsr.definitie.DomeinDefinitieEntity

@ApplicationScoped
class DomeinDefinitieRepository : PanacheRepository<DomeinDefinitieEntity> {

    fun findByNaam(naam: String) = find("naam", naam).firstResult()
}
