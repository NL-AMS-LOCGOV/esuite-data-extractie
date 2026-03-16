package net.atos.esuite.extract.db.basisgegevens.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.basisgegevens.entity.SubjectEntity

@Singleton
class SubjectRepository : PanacheRepository<SubjectEntity>
