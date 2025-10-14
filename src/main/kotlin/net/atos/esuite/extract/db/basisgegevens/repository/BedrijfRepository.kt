package net.atos.esuite.extract.db.basisgegevens.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import net.atos.esuite.extract.db.basisgegevens.entity.BedrijfEntity

@ApplicationScoped
class BedrijfRepository : PanacheRepository<BedrijfEntity> {

    fun listByKvkNummer(kvkNummer: String) =
        find("kvknummer", kvkNummer)

    fun listByVestigingsnummer(vestigingsnummer: String) =
        find("vestigingsnummer", vestigingsnummer)

    fun listByKvkNummerAndVestigingsnummer(kvkNummer: String, vestigingsnummer: String) =
        find("kvknummer = ?1 and vestigingsnummer = ?2", kvkNummer, vestigingsnummer)
}

