package net.atos.esuite.extract.db.dsr.entity.domein

import jakarta.persistence.*
import net.atos.esuite.extract.db.dsr.entity.definitie.DomeinObjectDefinitieEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.time.LocalDate

/**
 * Entity class voor een domeinobject.
 */

@Entity
@Table(name = "dsr_domein_object", schema = "dsr")
class DomeinObjectEntity {

    @Id
    @Column(name = "id_domein_object")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_def_domein_object", referencedColumnName = "id_def_domein_object")
    lateinit var domeinObjectDefinitie: DomeinObjectDefinitieEntity

    // Gebruikersnaam van medewerker die domein object heeft aangemaakt
    @Column(name = "id_aangemaakt_door", length = 64)
    lateinit var idAangemaaktDoor: String

    // Datum waarop domein object is aangemaakt
    @Column(name = "aangemaakt_op")
    lateinit var aangemaaktOp: LocalDate

    // Gebruikersnaam van medewerker die domein object als laatste heeft gewijzigd
    @Column(name = "id_gewijzigd_door", length = 64)
    var idGewijzigdDoor: String? = null

    // Datum waarop domein object de laatste keer is gewijzigd
    @Column(name = "gewijzigd_op")
    var gewijzigdOp: LocalDate? = null

    @OneToMany(mappedBy = "domeinObject")
    lateinit var attributen: MutableList<AttribuutEntity>

    @OneToMany(mappedBy = "domeinObject")
    @Fetch(FetchMode.JOIN)
    lateinit var koppelingen: MutableList<DomeinObjectKoppelingEntity>

    @OneToMany(mappedBy = "domeinObject")
    @OrderBy("identifier desc")
    lateinit var historie: MutableList<DomeinObjectHistorieEntity>
}
