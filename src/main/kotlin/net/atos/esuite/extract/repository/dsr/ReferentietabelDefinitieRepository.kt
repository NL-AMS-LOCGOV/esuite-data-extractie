package net.atos.esuite.extract.repository.dsr

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.dsr.definitie.ReferentietabelDefinitieEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class ReferentietabelDefinitieRepository : PanacheRepository<ReferentietabelDefinitieEntity> {

    fun listAll(pageIndex: Int, pageSize: Int) =
        ListResult(
            findAll().page(pageIndex, pageSize).list(),
            count().toInt()
        )

    fun findByNaam(naam: String) = find("naam", naam).firstResult()
}
