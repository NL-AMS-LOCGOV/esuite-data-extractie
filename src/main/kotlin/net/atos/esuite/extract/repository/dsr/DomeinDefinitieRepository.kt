package net.atos.esuite.extract.repository.dsr

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.criteria.CriteriaBuilder
import net.atos.esuite.extract.entity.dsr.definitie.DomeinDefinitieEntity
import net.atos.esuite.extract.entity.dsr.definitie.ReferentietabelDefinitieEntity
import net.atos.esuite.extract.entity.identity.AfdelingEntity
import net.atos.esuite.extract.repository.BaseRepository
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class DomeinDefinitieRepository : BaseRepository<DomeinDefinitieEntity>(DomeinDefinitieEntity::class.java) {
}
