package net.atos.esuite.extract.db.repository.zaak

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.zakenmagazijn.ReferentieZaakTypeEntity

const val ZAAKTYPE_ID_PREFIX = "ZTC2:"

@ApplicationScoped
class ZaaktypeRepository : PanacheRepository<ReferentieZaakTypeEntity> {

    fun findByNaam(naam: String) = find("naam", naam).firstResult()
}
