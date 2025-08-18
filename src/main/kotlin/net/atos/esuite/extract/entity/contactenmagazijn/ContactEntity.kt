package net.atos.esuite.extract.entity.contactenmagazijn

import jakarta.persistence.*
import net.atos.esuite.extract.entity.configuratiemagazijn.ReferentieKanaalEntity
import net.atos.esuite.extract.entity.configuratiemagazijn.ReferentieOrganisatieEntity
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.Instant


@Entity
@Table(name = "con_contact", schema = "contactenmagazijn")
class ContactEntity {

    @Id
    @Column(name = "id_contact")
    var identifier: Long = 0

    @Column(name = "id_functioneel", length = 128)
    lateinit var functioneelId: String

    @Column(name = "id_aangemaaktdoor", length = 128)
    lateinit var aangemaaktDoorId: String

    @Column(name = "antwoord", length = Int.MAX_VALUE)
    @Lob
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    var antwoord: String? = null

    @Column(name = "vraag", length = Int.MAX_VALUE)
    @Lob
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    var vraag: String? = null

    @Column(name = "telefoon", length = 20)
    var telefoon: String? = null

    @Column(name = "telefoon_alternatief", length = 20)
    var telefoonAlternatief: String? = null

    @Column(name = "emailadres", length = 128)
    var emailadres: String? = null

    @Column(name = "ind_vertrouwelijk")
    var indicatieVertrouwelijk = false

    @Column(name = "ind_verwijderbaar")
    var verwijderbaar = false

    @Column(name = "ind_in_vernietiging")
    var inVernietiging = false

    @Column(name = "id_aanvrager")
    var aanvragerSubjectId : Long? = null

    @OneToMany(mappedBy = "contact")
    val gekoppeldeBAGObjecten: MutableList<ContactBAGObjectEntity> = mutableListOf()

    @ManyToOne
    @JoinColumn(name = "id_contactprioriteit")
    var contactPrioriteit: ReferentieContactPrioriteitEntity? = null

    @ManyToOne
    @JoinColumn(name = "id_contactstatus")
    var contactStatus: ReferentieContactStatusEntity? = null

    @ManyToOne
    @JoinColumn(name = "id_contacttype")
    var contactType: ReferentieContactTypeEntity? = null

    @Column(name = "startdatumtijd")
    lateinit var startdatumtijd: Instant

    @Column(name = "streefdatumtijd")
    var streefdatumtijd: Instant? = null

    @Column(name = "einddatumtijd")
    var einddatumtijd: Instant? = null

    @OneToOne
    @JoinColumn(name = "id_kanaal", referencedColumnName = "id_kanaal")
    var kanaal: ReferentieKanaalEntity? = null

    @Column(name = "label_kennisbankitem", length = 255)
    var kennisbankItemLabel: String? = null

    @Column(name = "id_groep", length = 128)
    var groepId: String? = null

    @Column(name = "id_afdeling", length = 128)
    var afdelingId: String? = null

    @Column(name = "id_behandelaar", length = 64)
    var behandelaarId: String? = null

    @OneToMany(mappedBy = "contact")
    @OrderBy("identifier DESC")
    val contactHistorie: MutableList<ContactHistorieEntity> = mutableListOf()

    @OneToMany(mappedBy = "contact")
    @OrderBy(value = "datumantwoord DESC")
    val voorlopigeAntwoorden: MutableList<VoorlopigAntwoordEntity> = mutableListOf()

    @ManyToMany
    @JoinTable(
        name = "con_contact_contact", schema = "contactenmagazijn",
        joinColumns = [JoinColumn(name = "id_contact_01", referencedColumnName = "id_contact")],
        inverseJoinColumns = [JoinColumn(name = "id_contact_02", referencedColumnName = "id_contact")]
    )
    val gekoppeldeContacten1: MutableSet<ContactEntity> = mutableSetOf()

    @ManyToMany
    @JoinTable(
        name = "con_contact_contact", schema = "contactenmagazijn",
        joinColumns = [JoinColumn(name = "id_contact_02", referencedColumnName = "id_contact")],
        inverseJoinColumns = [JoinColumn(name = "id_contact_01", referencedColumnName = "id_contact")]
    )
    val gekoppeldeContacten2: MutableSet<ContactEntity> = mutableSetOf()

    @OneToOne
    @JoinColumn(name = "id_organisatie", referencedColumnName = "id_organisatie")
    var organisatie: ReferentieOrganisatieEntity? = null
}
