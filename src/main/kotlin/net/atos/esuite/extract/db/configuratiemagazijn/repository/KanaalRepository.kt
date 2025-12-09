package net.atos.esuite.extract.db.configuratiemagazijn.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.configuratiemagazijn.entity.KanaalEntity

@ApplicationScoped
class KanaalRepository : PanacheRepository<KanaalEntity> {
}
