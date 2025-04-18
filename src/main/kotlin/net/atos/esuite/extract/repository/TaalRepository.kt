package net.atos.esuite.extract.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.zakenmagazijn.ReferentieTaalEntity

@ApplicationScoped
class TaalRepository : PanacheRepository<ReferentieTaalEntity> {
}
