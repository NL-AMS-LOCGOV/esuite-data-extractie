package net.atos.esuite.extract.repository.zaak

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.entity.zakenmagazijn.ZaakEntity
import net.atos.esuite.extract.repository.ListResult

@ApplicationScoped
class ZaakRepository : PanacheRepository<ZaakEntity> {

    fun findByFunctioneleIdentificatie(functioneleIdentificatie: String) =
        find("functioneelId", functioneleIdentificatie).firstResult()

    fun listByZaaktypeFunctioneelId(
        zaaktypeFunctioneelId: String,
        inclusiefOpen: Boolean, // ToDo: Tevens open zaken ophalen
        pageIndex: Int,
        pageSize: Int
    ): ListResult<ZaakEntity> {
        val query = """
            SELECT zaak FROM ZaakEntity zaak 
            WHERE zaak.zaaktypeId = (
                SELECT CONCAT('$ZAAKTYPE_ID_PREFIX', zaaktype.identifier) 
                FROM ReferentieZaakTypeEntity zaaktype 
                WHERE zaaktype.functioneelId = ?1
            )
        """
        return ListResult(
            find(query, zaaktypeFunctioneelId).page(pageIndex, pageSize).list(),
            count(query, zaaktypeFunctioneelId).toInt()
        )
    }
}
