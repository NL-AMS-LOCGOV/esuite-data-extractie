package net.atos.esuite.extract.repository.basisgegevens

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.basisgegevens.PersoonEntity

@ApplicationScoped
class PersoonRepository : PanacheRepository<PersoonEntity> {
    
    fun findByBSN(bsn: String) =
        find("burgerServiceNummer", bsn).firstResult()
}
