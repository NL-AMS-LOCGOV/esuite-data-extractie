package net.atos.esuite.extract.db.entity.dsr.domein

import jakarta.persistence.*

/**
 * Entity voor een koppeling tussen een DSR-domeinobject en een ander type object,
 * bv zaken, contacten.
*/

@Entity
@Table(name = "dsr_domein_object_koppeling", schema = "dsr")
class DomeinObjectKoppelingEntity {

    @Id
    @Column(name = "id_domein_object_koppeling")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_domein_object", referencedColumnName = "id_domein_object")
    lateinit var domeinObject: DomeinObjectEntity

    // Geeft aan aan welk type het domein object gekoppeld is (ZAAK, CONTACT, BAG_OBJECT, PERSOON, BEDRIJF)
    @Column(name = "gekoppeld_aan_type", length = 16)
    lateinit var gekoppeldAanType: String

    // ID van tabel zakenmagazijn.zkn_zaak, contactenmagazijn.con_contact, basisgegevens.gm_personen, basisgegevens.gm_bedrijf,
    // of een ID van een BAG-object, afh. van kolom "gekoppeld_aan_type"
    @Column(name = "id_gekoppeld_object", length = 64)
    lateinit var idGekoppeldObject: String
}
