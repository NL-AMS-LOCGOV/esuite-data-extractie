package net.atos.esuite.extract.db.dsr.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.dsr.entity.domein.DomeinObjectEntity

@Singleton
class DomeinObjectRepository : PanacheRepository<DomeinObjectEntity> {

    fun countByDomeinDefinitieId(domeinDefinitieId: Long): Long {
        return count("domeinObjectDefinitie.domeinDefinitie.identifier", domeinDefinitieId)
    }

    fun listByDomeinNaam(domeinNaam: String) =
        find("domeinObjectDefinitie.domeinDefinitie.naam = ?1", domeinNaam)
}

