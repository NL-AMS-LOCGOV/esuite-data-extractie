package net.atos.esuite.extract.repository.document

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.zakenmagazijn.ReferentieDocumentVormEntity

@ApplicationScoped
class DocumentVormRepository : PanacheRepository<ReferentieDocumentVormEntity> {
}
