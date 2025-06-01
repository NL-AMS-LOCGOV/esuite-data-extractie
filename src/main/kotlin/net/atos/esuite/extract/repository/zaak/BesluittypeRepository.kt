package net.atos.esuite.extract.repository.zaak

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.zakenmagazijn.ReferentieBesluittypeEntity

@ApplicationScoped
class BesluittypeRepository : PanacheRepository<ReferentieBesluittypeEntity> {
}
