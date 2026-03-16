package net.atos.esuite.extract.db.dsr.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.dsr.entity.definitie.DomeinDefinitieEntity

@Singleton
class DomeinDefinitieRepository : PanacheRepository<DomeinDefinitieEntity> {

    fun findByNaam(naam: String) = find("naam", naam).firstResult()
}
