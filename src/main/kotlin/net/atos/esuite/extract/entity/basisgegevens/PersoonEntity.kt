package net.atos.esuite.extract.entity.basisgegevens

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.PrimaryKeyJoinColumn
import jakarta.persistence.Table

@Entity
@Table(name = "gm_personen", schema = "basisgegevens" )
@PrimaryKeyJoinColumn(name = "id_persoon", referencedColumnName = "id_subject")
class PersoonEntity: SubjectEntity() {

    @Column(name = "burgerservicenummer", length = 9)
    var burgerServiceNummer: String? = null

    @Column(name = "voornamen", length = 200)
    var voornamen: String? = null

    @Column(name = "voorletters", length = 20)
    var voorletters: String? = null

    @Column(name = "geslachtsnaam", length = 200)
    var geslachtsNaam: String? = null

    @Column(name = "voorvoegsel", length = 10)
    var voorvoegsel: String? = null
}
