package net.atos.esuite.extract.entity.basisgegevens

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.PrimaryKeyJoinColumn
import jakarta.persistence.Table

@Entity
@Table(name = "gm_bedrijf", schema = "basisgegevens")
@PrimaryKeyJoinColumn(name = "id_bedrijf", referencedColumnName = "id_subject")
class BedrijfEntity: SubjectEntity() {

    @Column(name = "kvknummer", length = 8)
    var kvknummer: String? = null

    @Column(name = "vestigingsnummer", length = 12)
    var vestigingsnummer: String? = null

    @Column(name = "buitenlandshandelsregisternummer", length = 255)
    var buitenlandsHandelsregisternummer: String? = null

    @Column(name = "bedrijfsnaam", length = 128)
    var bedrijfsnaam: String? = null

}
