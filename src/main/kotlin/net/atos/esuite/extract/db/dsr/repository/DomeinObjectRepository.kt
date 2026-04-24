package net.atos.esuite.extract.db.dsr.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.dsr.entity.domein.DomeinObjectEntity

private const val DOMEIN_KOPPEL_TYPE_ZAAK = "ZAAK"
private const val DOMEIN_KOPPEL_TYPE_CONTACT = "CONTACT"

@Singleton
class DomeinObjectRepository : PanacheRepository<DomeinObjectEntity> {

    fun countByDomeinDefinitieId(domeinDefinitieId: Long) =
        count("domeinObjectDefinitie.domeinDefinitie.identifier", domeinDefinitieId)

    fun listByDomeinNaam(domeinNaam: String) =
        find("domeinObjectDefinitie.domeinDefinitie.naam = ?1", domeinNaam)

    fun findByGekoppeldeZaak(functioneelId: String): List<DomeinObjectEntity> =
        findByGekoppeldObject(DOMEIN_KOPPEL_TYPE_ZAAK, functioneelId)

    fun findByGekoppeldContact(functioneelId: String): List<DomeinObjectEntity> =
        findByGekoppeldObject(DOMEIN_KOPPEL_TYPE_CONTACT, functioneelId)

    private fun findByGekoppeldObject(koppelType: String, gekoppeldObjectId: String): List<DomeinObjectEntity> =
        find(
            "SELECT d FROM DomeinObjectEntity d JOIN d.koppelingen k WHERE k.gekoppeldAanType = ?1 AND k.idGekoppeldObject = ?2",
            koppelType, gekoppeldObjectId
        )
            .list()
}

