package net.atos.esuite.extract.db.zakenmagazijn.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.zakenmagazijn.entity.ZaakTypeEntity

const val ZAAKTYPE_ID_PREFIX = "ZTC2:"

@ApplicationScoped
class ZaaktypeRepository : PanacheRepository<ZaakTypeEntity> {

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()
}
