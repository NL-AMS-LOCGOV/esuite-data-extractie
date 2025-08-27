package net.atos.esuite.extract.db.repository.zaak

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.zakenmagazijn.ZaakEntity

@ApplicationScoped
class ZaakRepository : PanacheRepository<ZaakEntity> {

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()

    fun listByZaaktypeFunctioneelId(
        zaaktypeFunctioneelId: String,
        inclusiefOpen: Boolean, // ToDo: Tevens open zaken ophalen
    ): PanacheQuery<ZaakEntity> {
        val query = """
            SELECT zaak FROM ZaakEntity zaak 
            WHERE zaak.zaaktypeId = (
                SELECT CONCAT('$ZAAKTYPE_ID_PREFIX', zaaktype.identifier) 
                FROM ReferentieZaakTypeEntity zaaktype 
                WHERE zaaktype.functioneelId = ?1
            )
        """
        return find(query, zaaktypeFunctioneelId)
    }
}
