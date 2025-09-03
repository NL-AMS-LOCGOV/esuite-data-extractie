package net.atos.esuite.extract.db.repository.zaak

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.zakenmagazijn.ResultaatEntity

@ApplicationScoped
class ResultaatRepository : PanacheRepository<ResultaatEntity>
