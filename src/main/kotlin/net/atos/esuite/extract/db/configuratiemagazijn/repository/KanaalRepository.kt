package net.atos.esuite.extract.db.configuratiemagazijn.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.configuratiemagazijn.entity.KanaalEntity

@Singleton
class KanaalRepository : PanacheRepository<KanaalEntity> {
}
