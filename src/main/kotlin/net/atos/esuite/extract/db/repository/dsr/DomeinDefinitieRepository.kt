package net.atos.esuite.extract.db.repository.dsr

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.dsr.definitie.DomeinDefinitieEntity
import net.atos.esuite.extract.db.util.ListResult

@ApplicationScoped
class DomeinDefinitieRepository : PanacheRepository<DomeinDefinitieEntity> {

    fun listAll(pageIndex: Int, pageSize: Int): ListResult<DomeinDefinitieEntity> =
        ListResult(
            findAll().page(pageIndex, pageSize).list(),
            count().toInt()
        )

    fun findByNaam(naam: String) = find("naam", naam).firstResult()
}
