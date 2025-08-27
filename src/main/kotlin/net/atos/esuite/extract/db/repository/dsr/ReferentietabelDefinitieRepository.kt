package net.atos.esuite.extract.db.repository.dsr

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.dsr.definitie.ReferentietabelDefinitieEntity

@ApplicationScoped
class ReferentietabelDefinitieRepository : PanacheRepository<ReferentietabelDefinitieEntity> {

    fun findByNaam(naam: String) = find("naam", naam).firstResult()
}
