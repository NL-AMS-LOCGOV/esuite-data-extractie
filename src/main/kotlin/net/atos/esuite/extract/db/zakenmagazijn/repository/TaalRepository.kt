package net.atos.esuite.extract.db.zakenmagazijn.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.zakenmagazijn.entity.TaalEntity

@ApplicationScoped
class TaalRepository : PanacheRepository<TaalEntity> {
}
