package net.atos.esuite.extract.repository.dsr

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import net.atos.esuite.extract.entity.dsr.definitie.ReferentietabelDefinitieEntity
import net.atos.esuite.extract.entity.dsr.domein.DomeinObjectEntity
import net.atos.esuite.extract.entity.dsr.tabel.ReferentietabelRecordEntity
import net.atos.esuite.extract.entity.zakenmagazijn.ReferentieZaakTypeEntity
import net.atos.esuite.extract.entity.zakenmagazijn.ZaakEntity
import net.atos.esuite.extract.repository.ListResult
import net.atos.esuite.extract.repository.zaak.ZaakRepository.Companion.ZAAKTYPE_ID_PREFIX

@ApplicationScoped
class DomeinObjectRepository : PanacheRepository<DomeinObjectEntity> {

    fun countByDomeinDefinitieId(domeinDefinitieId: Long): Long {
        return count("domeinObjectDefinitie.domeinDefinitie.identifier", domeinDefinitieId)
    }
}

