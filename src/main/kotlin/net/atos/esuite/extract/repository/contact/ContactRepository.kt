package net.atos.esuite.extract.repository.contact

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.contactenmagazijn.ContactEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class ContactRepository : PanacheRepository<ContactEntity> {

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()

    fun listAll(pageIndex: Int, pageSize: Int) =
        ListResult(
            findAll().page(pageIndex, pageSize).list(),
            count().toInt()
        )
}
