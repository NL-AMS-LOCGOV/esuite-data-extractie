package net.atos.esuite.extract.db.repository.zaak

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.zakenmagazijn.BesluittypeEntity

@ApplicationScoped
class BesluittypeRepository : PanacheRepository<BesluittypeEntity>

