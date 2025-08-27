package net.atos.esuite.extract.db.repository.contact

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.contactenmagazijn.ContactEntity

@ApplicationScoped
class ContactRepository : PanacheRepository<ContactEntity> {

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()
}
