package net.atos.esuite.extract.db.zakenmagazijn.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.zakenmagazijn.entity.ZaakEntity

@ApplicationScoped
class ZaakRepository : PanacheRepository<ZaakEntity> {

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()

    fun listByZaaktypeFunctioneelId(zaaktypeFunctioneelId: String, inclusiefOpen: Boolean): PanacheQuery<ZaakEntity> {
        val query = if (inclusiefOpen)
            """
            SELECT zaak FROM ZaakEntity zaak 
            WHERE zaak.zaaktypeId = (
                SELECT CONCAT('$ZAAKTYPE_ID_PREFIX', zaaktype.identifier) 
                FROM ZaakTypeEntity zaaktype 
                WHERE zaaktype.functioneelId = ?1)
            """
        else
            """
            SELECT zaak FROM ZaakEntity zaak 
            WHERE zaak.zaaktypeId = (
                SELECT CONCAT('$ZAAKTYPE_ID_PREFIX', zaaktype.identifier) 
                FROM ZaakTypeEntity zaaktype 
                WHERE zaaktype.functioneelId = ?1) 
                AND zaak.einddatum IS NOT NULL
            """

        return find(query, zaaktypeFunctioneelId)
    }
}
