package net.atos.esuite.extract.db.entity.basisgegevens

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "gm_persoonreisdocument", schema = "basisgegevens")
class PersoonReisdocumentEntity {

    @Id
    @Column(name = "id_persoonreisdocument")
    var identifier: Long = 0

    @Column(name = "ind_onttrekking")
    var indicatieOnttrekking = false

    @Column(name = "autoriteit_ontrekking", length = 255)
    var autoriteitOntrekking: String? = null

    // Indicatie van rechtswege vervallen (I,V)
    @Column(name = "ind_vervallen", length = 1)
    var indicatieVervallen: String? = null

    @Column(name = "autoriteit_vervallen", length = 255)
    var autoriteitVervallen: String? = null

    @Column(name = "einddatumgeldigheid")
    var einddatumGeldigheid: LocalDate? = null

    @Column(name = "reisdocumentnummer", length = 10)
    var reisdocumentnummer: String? = null

    @Column(name = "datumuitgifte")
    var uitgiftedatum: LocalDate? = null

    @Column(name = "autoriteituitgifte", length = 128)
    var autoriteitUitgifte: String? = null

    @ManyToOne
    @JoinColumn(name = "id_persoon", referencedColumnName = "id_persoon")
    lateinit var persoon: PersoonEntity

    @ManyToOne
    @JoinColumn(name = "id_reisdocument", referencedColumnName = "gbacode")
    lateinit var reisdocument: ReisdocumentEntity
}
