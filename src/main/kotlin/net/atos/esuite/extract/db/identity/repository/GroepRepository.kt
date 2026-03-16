package net.atos.esuite.extract.db.identity.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.identity.entity.GroepEntity

@Singleton
class GroepRepository : PanacheRepository<GroepEntity> {

    fun findByNaam(naam: String) = find("naam", naam).firstResult()
}
