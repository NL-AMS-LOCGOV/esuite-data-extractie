package net.atos.esuite.extract.repository.identity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.criteria.CriteriaBuilder
import net.atos.esuite.extract.entity.identity.AfdelingEntity
import net.atos.esuite.extract.repository.BaseRepository
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class AfdelingRepository : BaseRepository<AfdelingEntity>(AfdelingEntity::class.java) {
}
