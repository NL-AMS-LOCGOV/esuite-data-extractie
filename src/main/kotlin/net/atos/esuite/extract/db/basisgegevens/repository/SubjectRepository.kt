package net.atos.esuite.extract.db.basisgegevens.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.basisgegevens.entity.SubjectEntity

@ApplicationScoped
class SubjectRepository : PanacheRepository<SubjectEntity>
