package net.atos.esuite.extract.repository.document

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.zakenmagazijn.DocumentInhoudEntity

@ApplicationScoped
class DocumentInhoudRepository : PanacheRepository<DocumentInhoudEntity> {
}
