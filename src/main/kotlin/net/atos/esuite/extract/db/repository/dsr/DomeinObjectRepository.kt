package net.atos.esuite.extract.db.repository.dsr

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.dsr.domein.DomeinObjectEntity

@ApplicationScoped
class DomeinObjectRepository : PanacheRepository<DomeinObjectEntity> {

    fun countByDomeinDefinitieId(domeinDefinitieId: Long): Long {
        return count("domeinObjectDefinitie.domeinDefinitie.identifier", domeinDefinitieId)
    }

    fun listByDomeinNaam(domeinNaam: String) =
        find("domeinObjectDefinitie.domeinDefinitie.naam = ?1", domeinNaam)
}

