package net.atos.esuite.extract.entity.zakenmagazijn

import jakarta.persistence.*
import java.time.Instant


@Entity
@Table(name = "zkn_zaak_notities", schema = "zakenmagazijn")
class ZaakNotitieEntity {

    @Id
    @Column(name = "id_zaak_notitie")
    var identifier: Long = 0

    // ID van de medewerker die de notite toegevoegd heeft
    @Column(name = "id_medewerker", length = 40)
    lateinit var medewerkerId: String

    // Datum en tijd waarop de notitie is toegevoegd
    @Column(name = "datum_tijd")
    lateinit var datumTijd: Instant

    // De inhoud van de notitie
    @Column(name = "notitie", length = Int.MAX_VALUE)
    var notitie: String? = null

    @ManyToOne
    @JoinColumn(name = "id_zaak", referencedColumnName = "id_zaak")
    lateinit var zaak: ZaakEntity
}
