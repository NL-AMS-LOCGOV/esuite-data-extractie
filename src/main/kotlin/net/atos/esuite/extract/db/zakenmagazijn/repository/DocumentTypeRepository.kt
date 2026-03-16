package net.atos.esuite.extract.db.zakenmagazijn.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.zakenmagazijn.entity.DocumentTypeEntity

@Singleton
class DocumentTypeRepository : PanacheRepository<DocumentTypeEntity> {
}
