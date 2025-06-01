package net.atos.esuite.extract.repository.zaak

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.zakenmagazijn.ReferentieZaakTypeEntity

@ApplicationScoped
class ZaaktypeRepository : PanacheRepository<ReferentieZaakTypeEntity> {

}
