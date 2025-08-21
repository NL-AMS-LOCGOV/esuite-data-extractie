package net.atos.esuite.extract.db.repository.basisgegevens

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.basisgegevens.PersoonEntity

@ApplicationScoped
class PersoonRepository : PanacheRepository<PersoonEntity> {
    
    fun findByBSN(bsn: String) =
        find("burgerServiceNummer", bsn).list()
}
