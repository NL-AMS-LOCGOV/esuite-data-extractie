package net.atos.esuite.extract.db.basisgegevens.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.basisgegevens.entity.PersoonEntity

@ApplicationScoped
class PersoonRepository : PanacheRepository<PersoonEntity> {

    fun findByBSN(bsn: String) =
        find("burgerServiceNummer", bsn).firstResult()
}
