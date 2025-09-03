package net.atos.esuite.extract.db.entity.zakenmagazijn

import jakarta.persistence.*

@Entity
@Table(name = "ztc_taakdocumentgroep", schema = "zakenmagazijn")
class ReferentieTaakDocumentGroepEntity {

    @Id
    @Column(name = "id_taakdocumentgroep")
    var identifier: Long = 0

    // Functionele naam van de taakdocumentgroe
    @Column(name = "functionele_naam", length = 255)
    lateinit var functioneleNaam: String

    @ManyToOne
    @JoinColumn(name = "id_zaaktype")
    lateinit var zaakType: ReferentieZaakTypeEntity

    @ManyToMany
    @JoinTable(
        name = "ztc_taakdocumentgroep_taakdocument", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_taakdocumentgroep", referencedColumnName = "id_taakdocumentgroep")],
        inverseJoinColumns = [JoinColumn(name = "id_taakdocument", referencedColumnName = "id_taakdocument")]
    )
    lateinit var taakDocumenten: MutableSet<ReferentieTaakDocumentEntity>
}
