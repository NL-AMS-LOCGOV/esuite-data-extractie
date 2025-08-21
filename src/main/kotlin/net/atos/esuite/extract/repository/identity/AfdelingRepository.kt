package net.atos.esuite.extract.repository.identity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.identity.AfdelingEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class AfdelingRepository : PanacheRepository<AfdelingEntity> {

    fun listAll(pageIndex: Int, pageSize: Int) =
        ListResult(
            findAll().page(pageIndex, pageSize).list(),
            count().toInt()
        )

    fun findByNaam(naam: String) = find("naam", naam).firstResult()
}
