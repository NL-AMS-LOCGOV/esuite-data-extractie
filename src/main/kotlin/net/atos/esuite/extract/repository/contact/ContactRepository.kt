package net.atos.esuite.extract.repository.contact

import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.contactenmagazijn.ContactEntity
import net.atos.esuite.extract.repository.BaseRepository

@ApplicationScoped
class ContactRepository : BaseRepository<ContactEntity> {

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()
}
