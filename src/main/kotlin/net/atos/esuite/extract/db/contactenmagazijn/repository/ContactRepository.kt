package net.atos.esuite.extract.db.contactenmagazijn.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.contactenmagazijn.entity.ContactEntity

@Singleton
class ContactRepository : PanacheRepository<ContactEntity> {

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()
}
