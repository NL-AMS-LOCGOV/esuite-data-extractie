package net.atos.esuite.extract.db.repository.basisgegevens

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.entity.basisgegevens.BedrijfEntity

@ApplicationScoped
class BedrijfRepository : PanacheRepository<BedrijfEntity> {

    fun listByKvkNummer(kvkNummer: String) =
        find("kvknummer", kvkNummer).list()

    fun listByVestigingsnummer(vestigingsnummer: String) =
        find("vestigingsnummer", vestigingsnummer).list()

    fun listByKvkNummerAndVestigingsnummer(kvkNummer: String, vestigingsnummer: String) =
        find("kvknummer = ?1 and vestigingsnummer = ?2", kvkNummer, vestigingsnummer).list()
}

