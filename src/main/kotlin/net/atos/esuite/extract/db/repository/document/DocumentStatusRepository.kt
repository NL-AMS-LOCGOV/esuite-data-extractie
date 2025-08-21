package net.atos.esuite.extract.db.repository.document

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.zakenmagazijn.ReferentieDocumentStatusEntity

@ApplicationScoped
class DocumentStatusRepository : PanacheRepository<ReferentieDocumentStatusEntity> {
}
