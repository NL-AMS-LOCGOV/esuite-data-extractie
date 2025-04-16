package net.atos.esuite.extract.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.zakenmagazijn.ReferentieZaaRelatietypeEntity

@ApplicationScoped
class ZaakRelatietypeRepository() : PanacheRepositoryBase<ReferentieZaaRelatietypeEntity, String> {
}
