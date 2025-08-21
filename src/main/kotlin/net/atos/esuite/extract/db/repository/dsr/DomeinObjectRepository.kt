package net.atos.esuite.extract.db.repository.dsr

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.dsr.domein.DomeinObjectEntity
import net.atos.esuite.extract.db.util.ListResult

@ApplicationScoped
class DomeinObjectRepository : PanacheRepository<DomeinObjectEntity> {

    fun countByDomeinDefinitieId(domeinDefinitieId: Long): Long {
        return count("domeinObjectDefinitie.domeinDefinitie.identifier", domeinDefinitieId)
    }

    fun listByDomeinNaam(domeinNaam: String, pageIndex: Int, pageSize: Int): ListResult<DomeinObjectEntity> {
        val filter = "domeinObjectDefinitie.domeinDefinitie.naam = ?1"
        return ListResult(
            find(filter, domeinNaam).page(pageIndex, pageSize).list(),
            find(filter, domeinNaam).count().toInt()
        )
    }
}

