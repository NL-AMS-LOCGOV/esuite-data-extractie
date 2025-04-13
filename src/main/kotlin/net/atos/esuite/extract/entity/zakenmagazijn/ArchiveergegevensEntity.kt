package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.*
import java.time.LocalDate


@Embeddable
class ArchiveergegevensEntity {

    @Column(name = "archief_reviewtermijn_einde")
    var reviewtermijnEinde: LocalDate? = null

    // Datum waarop de bewaartermijn afloopt
    @Column(name = "archief_bewaartermijn_einde")
    var bewaartermijnEinde: LocalDate? = null

    // Waardering van de bewaartermijn (B of V)
    @Column(name = "archief_bewaartermijn_waardering", length = 1)
    var bewaartermijnWaardering: String? = null

    // Datum waarop de zaak overgebracht moet worden
    @Column(name = "archief_overbrengen_op")
    var overbrengenOp: LocalDate? = null

    // Locatie/instantie waarnaar zaak overgebracht moet worden
    @Column(name = "archief_overbrengen_naar", length = 255)
    var overbrengenNaar: String? = null

    // Naam medewerker die zaak op overbrengen zet
    @Column(name = "archief_overbrengen_door", length = 128)
    var overbrengenDoor: String? = null

    @Embedded
    var overgebrachteGegevensEntity: OvergebrachteGegevensEntity? = null

    // Aanduiding beperking openbaarheid
    @Column(name = "archief_beperking_openbaarheid")
    var beperkingOpenbaarheid: Boolean? = null

    // Reden beperking openbaarheid
    @Column(name = "archief_beperking_openbaarheid_reden", length = Int.MAX_VALUE)
    var beperkingOpenbaarheidReden: String? = null

    // beperking openbaarheid datum vanaf
    @Column(name = "archief_beperking_openbaarheid_vanaf")
    var beperkingOpenbaarheidVanaf: LocalDate? = null

    // beperking openbaarheid datum tot en met
    @Column(name = "archief_beperking_openbaarheid_totenmet")
    var beperkingOpenbaarheidTotEnMet: LocalDate? = null

    // Naam van het zaaktype (zaaktype: naam_algemeen)
    @Column(name = "archief_zaaktypenaam", length = 255)
    var zaaktypeNaam: String? = null

    @Column(name = "archief_selectielijst_naam", length = 128)
    var selectielijstItemNaam: String? = null

    // Type overbrengen (1=Overdragen, 2=Overbrengen)
    @Column(name = "archief_overbrengen_type", length = 1)
    var overbrengenType: String? = null
}
