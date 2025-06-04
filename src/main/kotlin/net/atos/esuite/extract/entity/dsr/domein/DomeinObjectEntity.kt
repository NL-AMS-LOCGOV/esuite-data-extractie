package net.atos.esuite.extract.entity.dsr.domein

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OrderBy
import jakarta.persistence.Table
import net.atos.esuite.extract.entity.dsr.definitie.DomeinObjectDefinitieEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.time.LocalDate
import java.util.*

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

    // Datum waarop domeino bject de laatste keer is gewijzigd
    @Column(name = "gewijzigd_op")
    var gewijzigdOp: LocalDate? = null

    @OneToMany(mappedBy = "domeinObject")
    var attributen: MutableList<AttribuutEntity> = mutableListOf()

    @OneToMany(mappedBy = "domeinObject")
    @Fetch(FetchMode.JOIN)
    var koppelingen: MutableList<DomeinObjectKoppelingEntity> = mutableListOf()

    @OneToMany(mappedBy = "domeinObject")
    @OrderBy("identifier desc")
    var historie: MutableList<DomeinObjectHistorieEntity> = mutableListOf()
}
