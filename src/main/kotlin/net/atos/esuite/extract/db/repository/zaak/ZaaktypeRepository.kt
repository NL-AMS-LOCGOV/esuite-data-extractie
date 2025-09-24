package net.atos.esuite.extract.db.repository.zaak

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.zakenmagazijn.ZaakTypeEntity

const val ZAAKTYPE_ID_PREFIX = "ZTC2:"

@ApplicationScoped
class ZaaktypeRepository : PanacheRepository<ZaakTypeEntity> {

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()
}
