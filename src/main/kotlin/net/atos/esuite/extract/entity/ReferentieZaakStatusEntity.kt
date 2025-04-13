package net.atos.esuite.extract.entity

import jakarta.persistence.*

@Entity
@Table(name = "ztc_ref_zaakstatus", schema = "zakenmagazijn")
class ReferentieZaakStatusEntity : AbstractReferentieLongIdEntity() {

    @Id
    @Column(name = "id_zaakstatus")
    var identifier: Long = 0

    // indicatie of de zaakstatus een startstatus is
    @Column(name = "ind_startstatus")
    var indicatieStartstatus = false

    // indicatie of de zaakstatus een eindstatus is
    @Column(name = "ind_eindstatus")
    var indicatieEindstatus = false

    // de externe naam van de zaakstatus
    @Column(name = "ext_naam")
    var externeNaam: String? = null

    // uitwisselingscode voor STUF
    @Column(name = "uitwisselingscode")
    lateinit var uitwisselingsCode: String
}
